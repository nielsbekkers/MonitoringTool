/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import com.thoughtworks.xstream.XStream;
import entities.ProductDetail;
import entities.ProductTypes;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


/**
 *
 * @author mrx
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public String findBySoldandByPId(Integer sold, Integer pId) throws IOException{
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<AbstractFacade> c = cq.from(entityClass);
        cq.select(c);
        
        ProductTypes pt = new ProductTypes();
        pt.setPId(pId);
        
        cq.where(
                cb.equal(c.get("sold"), sold),
                cb.equal(c.get("pId"), pt)
        );
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        List<T> result = q.getResultList();
        
        //List<String> serialNumbersList = new ArrayList<String>();
        List<ProductDetail> serialNumbersList = new ArrayList<ProductDetail>();
        int i = 0;
        while(i < result.size()){
            ProductDetail pd = (ProductDetail) result.get(i);
            //serialNumbersList.add(pd.getSerialNumber());
            serialNumbersList.add(pd);
            i++;
        }

        Serializer serializer = new Persister();
        FileWriter resultXmlExtra = new FileWriter("c:\\temp2\\example.xml",false);
        resultXmlExtra.close();
        FileWriter resultXml = new FileWriter("c:\\temp2\\example.xml",true);
        
        resultXml.write("<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\">");
        //resultXml.write("<ProductDetails>");
        int j = 0;
        while(j < serialNumbersList.size()){
            try {
                ProductDetail pdx = serialNumbersList.get(j);
                ProductDetail pd = new ProductDetail();
                pd.setId(pdx.getId());
                pd.setSerialNumber(pdx.getSerialNumber());
                pd.setTimeUnix(pdx.getTimeUnix());
                pd.setProperty1(pdx.getProperty1());
                pd.setProperty2(pdx.getProperty2());
                pd.setProperty3(pdx.getProperty3());
                pd.setSold(pdx.getSold());
                
                serializer.write(pd, resultXml);
            } catch (Exception ex) {
                Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            j++;
        }
        //resultXml.write("</ProductDetails>");
        resultXml.write("</xml>");
        resultXml.close();
        
        File file = new File("c:\\temp2\\example.xml");
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        } finally {
            reader.close();
        }
        String outputXml = stringBuilder.toString(); 
        
        return outputXml;
    }
    
}

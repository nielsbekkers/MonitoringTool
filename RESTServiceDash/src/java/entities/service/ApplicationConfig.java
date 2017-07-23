/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mrx
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entities.service.CustomersFacadeREST.class);
        resources.add(entities.service.DatabaseChangedFacadeREST.class);
        resources.add(entities.service.LoginFacadeREST.class);
        resources.add(entities.service.ProductDetailFacadeREST.class);
        resources.add(entities.service.ProductDetailLast25FacadeREST.class);
        resources.add(entities.service.ProductTypesFacadeREST.class);
        resources.add(entities.service.SalesFacadeREST.class);
    }
    
}

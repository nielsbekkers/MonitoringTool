<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * @name: representative_model.php
 * @author: Frederik Vanstraelen
 */
class Representative_Model extends CI_Model
{

    function __construct() {
        parent::__construct();
        $this->load->database();
    }
    
    /**
     * 
     * @param array $data
     * @return array
     * valideer gebruiker
     */
    public function validate_user($data) {
        $this->db->where('username', $data['username']);
        $this->db->where('password', md5($data['password']));   //md5 hashing => veiligere opslag password in database
        return $this->db->get('Login')->row();
    }
    
    function generateProductSelectFromArray($aArray,$sName,$sFirstOption){
        // echo your opening Select
        $sHtml = "<select name='$sName'>";
        // Use simple foreach to generate the options
        $sHtml .= "<option value='null' ".set_select($sName,'null',TRUE).">".$sFirstOption ."</option>";
        foreach($aArray as $row) {
                $sHtml .= "<option value='".$row['PId']."' ".set_select($sName,$row['PId']).">".$row['Name']."</option>";
        }
        $sHtml .= "</select>";
        return $sHtml;
    }
    
    function generateCustomerSelectFromArray($aArray,$sName,$sFirstOption){
        // echo your opening Select
        $sHtml = "<select name='$sName'>";
        // Use simple foreach to generate the options
        $sHtml .= "<option value='null' ".set_select($sName,'null',TRUE).">$sFirstOption</option>";
        foreach($aArray as $row) {
            $sHtml .= "<option value='".$row['Id']."' ".set_select($sName,$row['Id']).">".$row['Name']."</option>";
//                $sHtml .= "<option value='".$row->Id."' ".set_select($sName,$row->Id).">".$row->Name."</option>";
        }
        $sHtml .= "</select>";
        return $sHtml;
    }
    
    public function getProductTypes(){
        
       
        $oResponse = \Httpful\Request::get('http://localhost:8080/RESTServiceDash/webresources/entities.producttypes')
                ->expectsXml()
                ->send();

        $aResponse = $oResponse->body->productTypes;
        
        $aProductTypes = array();
        $iTeller = 0;
        while ($iTeller < count($aResponse)) {
            $aElement = array();
            foreach ($aResponse[$iTeller] as $key => $value) {
                $aElement[ucfirst((string)$key)] = (string)$value;
            }
            array_push($aProductTypes, $aElement);
            $iTeller++;
        }

        
//        $query = $this->db->query('SELECT PId, Name, Amount FROM product_types');
//        $aProductTypes = array();
//        foreach ($query->result() as $row) {
//            array_push($aProductTypes, $row);
//        }
        return $aProductTypes;
    }
    
    public function getCustomers(){
        
        $oResponse = \Httpful\Request::get('http://localhost:8080/RESTServiceDash/webresources/entities.customers')
                ->expectsXml()
                ->send();

        $aResponse = $oResponse->body->customers;
        
        $aCustomers = array();
        $iTeller = 0;
        while ($iTeller < count($aResponse)) {
            $aElement = array();
            foreach ($aResponse[$iTeller] as $key => $value) {
                $aElement[ucfirst((string)$key)] = (string)$value;
            }
            array_push($aCustomers, $aElement);
            $iTeller++;
        }
        
        
//        $query = $this->db->query('SELECT Id, Name FROM customers');
//        $aCustomers = array();
//        foreach ($query->result() as $row) {
//            array_push($aCustomers, $row);
//        }
        return $aCustomers;
    }
    
    public function saveNewSale($sPId,$sSN,$sCId){
        $sql = "INSERT INTO sales (PId,Serial_Number,Client_Id) VALUES (".$this->db->escape($sPId).",".$this->db->escape($sSN).",".$this->db->escape($sCId).")";
        $this->db->query($sql);
        $iRows = $this->db->affected_rows();
        if ($iRows==1) {
            $this->db->set("Sold",TRUE);
            $this->db->where("Serial_Number",$sSN);
            $this->db->update("product_detail");
            $iRows = $this->db->affected_rows();
            if ($iRows==1) {
                $sql = "SELECT Amount FROM product_types WHERE PId=" . $sPId;
                $query = $this->db->query($sql);
                $oRow = $query->row();
                $iAmount = $oRow->Amount;
                $iAmount--;
                $this->db->set('Amount',$iAmount);
                $this->db->where('PId',$sPId);
                $this->db->update('product_types');
                $iRows = $this->db->affected_rows();
            }
        }
        return $iRows;
//        $aValues = array(
//            'PId' => $this->db->escape($sPId),
//            'Serial_Number' => $this->db->escape($sSN),
//            'Client_Id' => $this->db->escape($sCI)
//        );
//        return $this->db->insert('sales',$aValues);
    }
    
    public function setDatabaseChangedDate(){
        $lTimeUnix = time();
        
        
    $oResponse = \Httpful\Request::put('http://localhost:8080/RESTServiceDash/webresources/entities.databasechanged/1')
                ->body('<?xml version="1.0" encoding="UTF-8" standalone="yes"?><databaseChanged><id>1</id><timeUnix>'.$lTimeUnix.'</timeUnix></databaseChanged>')
                ->sendsXml()
                ->send();

       
        
//        $this->db->set("Time_Unix",$lTimeUnix);
//        $this->db->where("Id","1");
//        $this->db->update("database_changed");
    }
    
    public function getFreeSerialNumbersArray($sPId){
        $query = $this->db->query('SELECT Serial_Number FROM product_detail WHERE PId = '.$this->db->escape($sPId).' AND Sold = 0');
        $aSerialNumbers = array();
        foreach ($query->result() as $row) {
            array_push($aSerialNumbers, $row->Serial_Number);
        }
        return $aSerialNumbers;
    }
    
    /**
     * stopt login validatie
     */
    function __destruct() {
        $this->db->close();
    }
}

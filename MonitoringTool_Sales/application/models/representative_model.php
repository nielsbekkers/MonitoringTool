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
        $sHtml .= "<option value='null'> $sFirstOption </option>";
        foreach($aArray as $row) {
            $sHtml .= "<option value=' $row->PId '> $row->Name </option>";
        }
        $sHtml .= "</select>";
        return $sHtml;
    }
    
    function generateCustomerSelectFromArray($aArray,$sName,$sFirstOption){
        // echo your opening Select
        $sHtml = "<select name='$sName'>";
        // Use simple foreach to generate the options
        $sHtml .= "<option value='null'> $sFirstOption </option>";
        foreach($aArray as $row) {
            $sHtml .= "<option value=' $row->Id '> $row->Name </option>";
        }
        $sHtml .= "</select>";
        return $sHtml;
    }
    
    public function getProductTypes(){
        $query = $this->db->query('SELECT PId, Name, Amount FROM product_types');
        $aProductTypes = array();
        foreach ($query->result() as $row) {
            array_push($aProductTypes, $row);
        }
        return $aProductTypes;
    }
    public function getCustomers(){
        $query = $this->db->query('SELECT Id, Name FROM customers');
        $aCustomers = array();
        foreach ($query->result() as $row) {
            array_push($aCustomers, $row);
        }
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
        }
        return $iRows;
//        $aValues = array(
//            'PId' => $this->db->escape($sPId),
//            'Serial_Number' => $this->db->escape($sSN),
//            'Client_Id' => $this->db->escape($sCI)
//        );
//        return $this->db->insert('sales',$aValues);
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

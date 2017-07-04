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
        $sHtml = "<select name=' $sName '>";
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
        $sHtml = "<select name=' $sName '>";
        // Use simple foreach to generate the options
        $sHtml .= "<option value='null'> $sFirstOption </option>";
        foreach($aArray as $row) {
            $sHtml .= "<option value=' $row '> $row </option>";
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

        $aCustomers = array();
        array_push($aCustomers,'Jos');
        array_push($aCustomers,'Piet');
        array_push($aCustomers,'George');
        return $aCustomers;
    }
    /**
     * stopt login validatie
     */
    function __destruct() {
        $this->db->close();
    }
}

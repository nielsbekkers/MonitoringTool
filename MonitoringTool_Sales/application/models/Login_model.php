<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * @name: Login_model.php
 * @author: Niels Bekkers
 */
class Login_model extends CI_Model
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
    /**
     * stopt login validatie
     */
    function __destruct() {
        $this->db->close();
    }
}

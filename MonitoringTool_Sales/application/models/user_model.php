<?php

/**
 * @name: user_model.php
 * @author: Niels Bekkers
 */

class user_model extends CI_Model
{
    function __construct()
    {
        // Roep de constructor op
        parent::__construct();
    }
    
    /**
     * 
     * @param array $data
     * @return array
     * insert into tbl login
     */
    function insertUser($data)
    {
        return $this->db->insert('login', $data);
     
    }
    
}
?>
<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class profieluser_model extends CI_Model
{
    function __construct() {
        parent::__construct();
        $this->load->database();
    }
    /*
     * Toont gegevens van 1 rij
     */
    public function get_SingleClient($id){
        
        $this->db->select('*');
        $this->db->from('login');
        //vergelijkt de id van de ingelogde gebruiker met deze van de database
        $this->db->where('id_user',$id);
        //haalt gegevens op
        $query = $this->db->get();
        //stuurt query uit als array
        return $query->result_array();
    }
    
    /**
     * 
     * @param int $id
     * @param array $data
     * @return int,array
     * Updaten van klantgegevens
     */
    
    function update_klant($id,$data){
        
        $this->db->where('id_user',$id);
        
        return $this->db->update('tblklant',$data);
    }
    /**
     * 
     * @param array $data2
     * @return array
     * insert into tabel tblklant
     */
    function insertUserTotblklant($data2)
    {
        return $this->db->insert('tblklant',$data2);
    }
}
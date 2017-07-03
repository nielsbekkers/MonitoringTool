<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * @name Home.php
 * @author Niels Bekkers
 */
class Home extends CI_Controller
{

    function __construct() {
        parent::__construct();

        if(empty($this->session->userdata('id_user'))) {
            $this->session->set_flashdata('flash_data', 'You don\'t have access!');
            redirect('login');
        }
    }

    public function index() {
             
        $this->load->view("home");
    }
    /**
     * functie voor uit te logen 
     * session data wordt leeggemaakt
     */
    public function logout() {
        $data = ['id_user', 'username'];
        $this->session->unset_userdata($data);

        redirect('login');
    }
}

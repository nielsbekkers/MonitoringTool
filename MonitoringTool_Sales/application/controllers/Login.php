<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * @name Login.php
 * @author Niels Bekkers
 */
class Login extends CI_Controller
{

    function __construct() {
        parent::__construct();
        $this->load->model("login_model", "login");
        if(!empty($_SESSION['id_user']))
            redirect('home');
    }

    public function index() {
        if($_POST) {
            $result = $this->login->validate_user($_POST);
            if(!empty($result)) {
                $data = [
                    'id_user' => $result->id_user,
                    'username' => $result->username,
                ];

                   $this->session->set_userdata($data);         //Sessie gebruikt in controller Home.php
                   redirect('representative');            				//adminpagina
                

            } else {
                redirect('login');    
            }
        }

        $this->load->view("login");
    }
}

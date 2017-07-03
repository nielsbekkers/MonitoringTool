<?php
class Registreer extends CI_Controller
{
    /**
      * @name Registreer.php
      * @author Niels Bekkers
    */
    public function __construct()
    {
        parent::__construct();
        $this->load->helper(array('form','url'));
        $this->load->library(array('session', 'form_validation', 'email'));
        $this->load->database();
        $this->load->model('user_model');
    }
    
    function index()
    {
        $this->register();      //Voer functie register() uit
    }

    function register()
    {
        //validatie regels
        
        $this->form_validation->set_rules('username', 'username','trim|required');
        $this->form_validation->set_rules('password', 'password','trim|required');
        
        //valideer forumier input
        if ($this->form_validation->run() == FALSE)
        {
            // error
            $this->load->view('Registreer');
        }
        else
        {
            //insert de gebruikersgegevens in de database
            $data = array(
                'username' => $this->input->post('username'),
                'password' => md5($this->input->post('password'))
            );
            
            // insert formulierdata in database
            if ($this->user_model->insertUser($data))
            {
                    //succesvol geregistreerd
                    $this->session->set_flashdata('flashSuccess','<center><br/><img src="https://upload.wikimedia.org/wikipedia/commons/b/b0/Light_green_check.svg" width="30" height="30"/><h1>Proficiat! U bent succesvol geregistreerd</h1><center>');
                    header('Refresh: 5; URL=');
                    redirect('Registreer');
                    
            }
            else
            {
                //error
               $this->session->set_flashdata('Oops! er is iets misgegaan, probeer nogmaals!');
                redirect('');
                
            }
        }

    }
    
}
?>
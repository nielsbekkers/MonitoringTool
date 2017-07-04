<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * @name Home.php
 * @author Niels Bekkers
 */
class Representative extends CI_Controller
{

    function __construct() {
        parent::__construct();

        if(empty($this->session->userdata('id_user'))) {
            $this->session->set_flashdata('flash_data', 'You don\'t have access!');
            redirect('login');
        }
    }

    public function index() {
        $this->load->model('representative_model','oRep');
        $aProductTypes = $this->oRep->getProductTypes();
        $aCustomers = $this->oRep->getCustomers();
        $this->sProductTypesSelect = $this->oRep->generateProductSelectFromArray($aProductTypes,'productTypesSelect','Select the product type');
        $this->sCustomersSelect = $this->oRep->generateCustomerSelectFromArray($aCustomers,'customersSelect','Select your customer');
        $sSN = "1234567";
        $iRows = "2";
        if (isset($_POST['SalesFormButton'])) {
            $iRows = $this->oRep->saveNewSale($_POST['productTypesSelect'],$sSN,$_POST['customersSelect']);
        }
        if ($iRows==TRUE) {
            echo "Rijen toegevoegd aan database: ".$iRows;
        }
        $this->load->view("representative");
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

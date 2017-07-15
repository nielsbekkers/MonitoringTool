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
        $sSN = "0";

        $iRows = 0;
        $iCounter = 0;
        if (isset($_POST['SalesFormButton'])) {
            $aSerialNumbers = $this->oRep->getFreeSerialNumbersArray($_POST['productTypesSelect']);
            $iAmountSold = $_POST['amountOfProducts'];
            while ($iCounter<$iAmountSold) {
                if (isset($aSerialNumbers[$iCounter])) {
                    $sSN = $aSerialNumbers[$iCounter];
                    $iRows += $this->oRep->saveNewSale($_POST['productTypesSelect'],$sSN,$_POST['customersSelect']);
                }
                $iCounter++;
            }
        }
        if ($iRows>0) {
            echo "Rijen toegevoegd aan database: ".$iRows;
        }  else {
            echo $iRows." rijen toegevoegd aan database! ";
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

<?php

namespace App\Services\Business;

use App\Models\UserModel;
use App\Models\CustomerModel;
use App\Services\Data\SecurityDAO;
use App\Services\Data\OrderDAO;
use App\Services\Data\CustomerDAO;
use App\Services\Data\Utility\DBConnect;

class SecurityService 
{
    // Define properties.
    private $verifyCred;
    //Method that will pass credentials to the DataAccess Layer.
    public function login(UserModel $credentials)
    {
        //Instantiate the Data Access Layer.
        $this->verifyCred = new SecurityDAO();
       
        //Return true or false by passing the credentials to the object.
        return $this->verifyCred->findByUser($credentials);
    }
    
    //Method to manage the customer data in the business layer.
    public function addCustomer(CustomerModel $customerData)
    {
        //Instantiate the Data Access Layer.
        $this->addNewCustomer = new CustomerDAO();
        
        //Return true or false by passing the credentials to the object.
        return $this->addNewCustomer->addCustomer($customerData);
    }
    
    public function addOrder(string $product, int $customerID)
    {
        //Instantiate the Data Access Layer.
        $this->addNewOrder = new OrderDAO();
        
        //Return true or false by passing the credentials to the object.
        return $this->addNewOrder->addOrder($product, $customerID);
    }
    
    //Manage ACID Transactions
    public function addAllInfo(string $product, int $customerID, CustomerModel $customerData)
    {
        //Create a connection to database by creating an instance of the class
        $conn = new DBConnect("cst256activity3");
        //call the method to create the connection.
        $dbObj = $conn->getDbConnect();
        //First turn off autocommit
        $conn->setDBAutoCommitFalse();
        //begin a transaction
        $conn->beginTransaction();
        //Instantiate the Data Access Layer
        $this->addNewCustomer = new CustomerDAO($dbObj);
        
        //Add the customer data
        $isSuccessful = $this->addNewCustomer->addCustomer($customerData);
        
        //Next customer ID
        $customerID = $this->addNewCustomer->getNextID();
        
        $this->addNewOrder = new OrderDAO($dbObj);
        
        $isSuccessfulOrder = $this->addNewOrder->addOrder($product, $customerID);
        
        //$isSuccessfulOrder = $this->addNewOrder->addOrder($product, $customerID);
        
        if ($isSuccessful && $isSuccessfulOrder)
        {
            $conn->commitTransaction();
            return true;
        }
        else 
        {
            $conn->rollbackTransaction();
            return false;
        }
    }
}

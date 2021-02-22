<?php

namespace App\Services\Data;

use App\Models\CustomerModel;
use Carbon\Exceptions\Exception;
use App\Services\Data\Utility\DBConnect;

class CustomerDAO
{
    //Define the connection string
    private $connObject; //DBObject
    private $dbname = "cst256activity3";
    private $dbQuery;
    private $connection;
    
    //Constructor that creates a connection with the database.
    public function __construct($dbObj) 
    {
        $this->dbObj = $dbObj;
    }
    
    public function addCustomer(CustomerModel $customerData) 
    {
        try 
        {
            //Define the query to search the database for the credentials.
            $this->dbQuery = "INSERT INTO customer
                            (FirstName, LastName) VALUES
                            ('{$customerData->getFirstName()}','{$customerData->getLastName()}')";
            
            //if the selected query returns a resultset.
            //$result = mysqli_query($this->conn, $this->dbQuery);
            //If there are rows that are returned, we have valid credentials.
            if ($this->dbObj->query($this->dbQuery)) 
            {
                //mysqli_free_result($result);
                //$this->connObject->closeDBConnect();
                return true;
            }
            else 
            {
                //$this->connObject->closeDBConnect();
                return false;
            }
        }
        catch (Exception $e)
        {
            echo $e->getMessage();
        }
    }
    
    //ACID
    //Get the next ID for the PK to put in the FK
    public function getNextID()
    {
        try 
        { //Define the query to get the next ID
            $this->dbQuery = "SELECT CustomerID from customer
                              ORDER BY CustomerID DESC Limit 0,1";
            $result = $this->dbObj->query($this->dbQuery);
            while ($row = mysqli_fetch_array($result)) 
            {
                return $row['CustomerID'];
            }
        }
        catch(Exception $e)
        {
            echo $e->getMessage();
        }
    }
}
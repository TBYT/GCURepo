<?php

namespace App\Services\Data;

use Carbon\Exceptions\Exception;

class OrderDAO
{
    //Define the connection string
    private $connObject; //DBObject
    private $dbname = "cst256activity3";
    private $dbQuery;
    private $connection;
    private $dbObj;
    
    //Constructor that creates a connection with the database.
    public function __construct($dbObj)
    {
        $this->dbObj = $dbObj;
    }
    
    //Method to add new order
    public function addOrder(string $product, int $customerID) 
    {
        try 
        {
            //Define the query to search the database for the credentials.
            $this->dbQuery = "INSERT INTO `order`
                            (Product, CustomerID) VALUES
                            ('". $product . "', " . $customerID . ")";
            
            //die($this->dbQuery);
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
}
<?php

namespace App\Services\Data\Utility;

use mysqli;

class DBConnect
{
    //Define the connection string
    private $conn;
    private $servername; 
    private $username; 
    private $password;
    private $dbname; 
    private $port; 
    private $dbQuery;
    
    //Constructor that creates a connection with the database.
    public function __construct(string $dbname) 
    {
        $this->dbname = $dbname;
        $this->servername = "localhost";
        $this->username = "root";
        $this->password = "root";
        //$dbname = "cst256activity3";
        
    }
    
    /*
     * Create a db connection.
     */
    public function getDbConnect()
    {
        //OOP Style
        $this->conn = new mysqli($this->servername, $this->username, $this->password, $this->dbname);
        //Create a connection to the database;
        
        // Procedural
        //$this->conn = mysqli_connect($this->servername, $this->username, $this->password, $this->dbname);
        //Make sure to test connection and see if there are any errors.
        
        //$this->conn = mysqli::connect($this->servername, $this->username, $this->password, $this->dbname);
        
        if ($this->conn->connect_error)
        {
            echo "Failed to connect to mysql." . $this->conn->connect_error;
            ecit();
        }
        return ($this->conn);
    }
    
    /*
     * Turn ON Autocommit
     */
    public function setDBAutoCommitTrue()
    {
        $this->conn->autocommit(TRUE);
    }
    
    /*
     * Turn OFF Autocommit
     */
    public function setDBAutoCommitFalse()
    {
        $this->conn->autocommit(FALSE);
    }
    
    /*
     * Close the connection
     */
    public function closeDBConnect()
    {
        //procedural style
       // mysqli_close($conn);
        //OOP Style
        $this->conn->close();
        
        //mysqli::close($this->conn); dont use this approach unless everything is in same class.
    }
    
    /*
     * Begin a transaction
     */
    public function beginTransaction()
    {
        $this->conn->begin_transaction();
    }
    
    /*
     * Commit a transaction
     */ 
    public function commitTransaction()
    {
        $this->conn->commit();
    }
    
    /*
     * Rollback a transaction
     */
    public function rollbackTransaction()
    {
        $this->conn->rollback();
    }
}
<?php
namespace App\Models;

class UserModel {
    private $username;
    private $password;

    //class constructor
    public function __construct($username, $password) 
    {
        $this->username = $username;
        $this->password = $password;
    }
    
    /**
     * @return mixed
     */
    public function getUsername()
    {
        return $this->username;
    }
    
    /**
     * @return mixed
     */
    public function getPassword()
    {
        return $this->password;
    }
    
    /**
     * @param mixed $username
     */
    public function setUsername($username)
    {
        $this->username = $username;
    }
    
    /**
     * @param mixed $uassword
     */
    public function setPassword($password)
    {
        $this->password = $password;
    }
}
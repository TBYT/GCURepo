<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\UserModel;
use App\Services\Business\SecurityService;

class LoginController extends Controller
{
    // To obtain the instance of the current HTTp request from a post
    public function index(Request $request) 
    {
        //Create a userModel with username and password.
        $credentials = new UserModel(request()->get('user_name'),request()->get('password'));
        
        //Instantiate the business logic layer.
        $serviceLogin = new SecurityService();
        
        //pass the credentials to the business layer.
        $isValid = $serviceLogin->login($credentials);
        
        //determine which view to display
        if ($isValid) 
        {
           //return view('loginPassed');
           return view('loginPassed2');
        }
        else 
        {
            return view('loginFailed');
        }
        
        
        //Put all the form values in an array called 'formValues'
       // $formValues = $request->all();
        // Get just the username from the form.
       // $userName = request()->get('user_name');
        //$userName = $request->get('user_name');
        // the get can be replaced by the input
        //$userName = request()->input('user_name'); //Lines 15 or 17, or 18., gives you same results
       // return $request->all();
        
        //$passWord = request()->get('password');
    }
}

<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\CustomerModel;
use App\Services\Business\SecurityService;

class OrderController extends Controller
{
    // To obtain the instance of the current HTTp request from a post
    public function index(Request $request) 
    {
        $customerData = new CustomerModel($request->input('firstName'),$request->input('lastName'));
        // Since we are not using a model
        //test the form variables being passed in
        //$this->validateForm($request);
        $product = request()->get('product');
        $customerID = $request->input('customerID');
        
        //Create a CustomerModel with FirstName and LastName.

        
        //Instantiate the business logic layer.
        $serviceCustomer = new SecurityService();
        
        //pass the credentials to the business layer.
        $isValid = $serviceCustomer->addAllInfo($product, $customerID, $customerData);
        
        //determine which view to display
        if ($isValid) 
        {
           //return view('loginPassed');
           echo "Order Data Committed Successfully";
        }
        else 
        {
            echo "Order Data was rollbacked.";
        }
        return view('order');
        
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
    
    // Validation added for Activity 3
    private function validateForm(Request $request)
    {
        // Setup data validation riles for login form
        $rules = ['user_name'=> 'Required | Between: 4, 10 | Alpha',
            'password'=> 'Required | Between: 4, 10'];
        //Run data validation rules
        $this->validate($request, $rules);
    }
}

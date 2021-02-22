<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\CustomerModel;
use App\Services\Business\SecurityService;

class CustomerController extends Controller
{
    // To obtain the instance of the current HTTp request from a post
    public function index(Request $request) 
    {
        //Added for activity 3
        //test the form variables being passed in
        //$this->validateForm($request);
        
        //Create a CustomerModel with FirstName and LastName.
        //$customerData = new CustomerModel(request()->get('firstName'),request()->get('lastName'));
        /*
        //Instantiate the business logic layer.
        $serviceCustomer = new SecurityService();
        
        //pass the credentials to the business layer.
        $isValid = $serviceCustomer->addCustomer($customerData);
        
        //determine which view to display
        if ($isValid) 
        {
           //return view('loginPassed');
           echo "Customer Data Added Successfully";
        }
        else 
        {
            echo "Customer Data was not added.";
        }
        */
        $nextID = 0;
        return redirect('neworder')->with('nextID', $nextID)->with('firstName',request()->get('firstName'))
        ->with('lastName',request()->get('lastName'));
        
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

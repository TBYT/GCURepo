<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\AssessmentModel;
use App\Services\Business\BusinessService;

class AssessmentController extends Controller
{
    // To obtain the instance of the current HTTp request from a post
    public function index(Request $request) 
    {
        $data = array();
        $model = new AssessmentModel($request->input('name'),$request->input('years'),$request->input('email'),$request->input('url'));
        
        $data[0] = $model->getName();
        $data[1] = $model->getExperience();
        $data[2] = $model->getEmail();
        $data[3] = $model->getUrl();
        
        
        //Instantiate the business logic layer.
        $service = new BusinessService();
        
        $isValid = $service->modelBiz($model);
        
        
        //determine which view to display
        if ($isValid)
        {
            $data[4] = 'String "CST-256" Matched in name :)';
            return view('assessment')->with('data', $data);
        }
        else
        {
            $data[4] = 'String "CST-256" did not matched in name :(';
            return view('assessment')->with('data', $data);
        }
    }
}

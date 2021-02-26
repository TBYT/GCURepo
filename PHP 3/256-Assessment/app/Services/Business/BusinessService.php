<?php

namespace App\Services\Business;

use App\Models\AssessmentModel;

class BusinessService 
{
    
    //Business Logic
    public function modelBiz(AssessmentModel $data)
    {
        //if name equals "CST-256"
        if ($data->getName() == "CST-256")
        {
            return true;
        }
        else 
        {
            //if email equals "CST-256"
            if ($data->getEmail() == "CST-256")
            {
                return true;
            }
            else
            {
                //if url equals "CST-256"
                if ($data->getUrl() == "CST-256")
                {
                    return true;
                }
                else
                {
                    //if experience equals "CST-256"
                    if ($data->getExperience() == "CST-256")
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                
            }
        }
    }
}

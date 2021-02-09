<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TestController extends Controller
{
    //
    function test()
    {
        echo "Hello World from Test Controller!";
    }
    function test2()
    {
        return view('helloworld');
    }
}
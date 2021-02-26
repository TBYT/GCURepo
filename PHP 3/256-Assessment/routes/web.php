<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

//get route
Route::get('/assessment', function ()
{
    $data = array();
    $data = ["","","","",""];
    return view('assessment')->with('data', $data);
});

//post route
Route::post('/postassessment','AssessmentController@index'); 

Route::get('contact', function () 
{
        return view('contact');
});

Route::get('about', function ()
{
    return view('about');
});
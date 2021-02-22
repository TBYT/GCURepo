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

//Route to add to order
Route::get('/neworder', function ()
{
    return view('order');
});
Route::post('/addorder','OrderController@index'); 

//Route to add to customer
Route::get('/customer', function ()
{
    return view('customer');
});
Route::post('/addcustomer','CustomerController@index'); 

Route::get('/login2', function ()
{
    return view('login2');
});

// route that will fire when we type 'login in the url.
// This is just the name people will see on the outside as they type in the url.
Route::get('/login', function () 
{
    echo ("This is a test");
    // View 'loginView' has to be the name of the file in the views.
    return view('loginView');
});

// When the data is posted from the login page with
// action set to "dologin" it will come here.
// Then route the request to a function called index.
// in the LoginController.
Route::post('/dologin','LoginController@index'); 


Route::get('/', function () {
    return view('welcome');
});

Route::get('/basic_response', function () 
{
        return 'Hello World';
});

Route::get('header', function ()
{
    return response("Hello CST-256 Brian", 200) -> header('Content-Type', 'text/html');
});

//route for new test page
Route::get('test1', function ()
{
    return view('test');
});
    
Route::get('contact', function () 
{
        return view('contact');
});

Route::get('about', function ()
{
    return view('about');
});
    
Route::get('customers', function ()
{
    $customers = [
        "Brian Basinger","Bill Hughes", "Customer Name"
    ];
    return view('internals.customers', ['customers_arr'=>$customers]);
});

Route::get('products', function ()
{
    $products = [
        "Apple IPhone 12","Samsung Galaxy Note 7", "Apple Airpods", "Windows 10 PC", "Apple MacBook Air"
    ];
    return view('products.products', ['products_arr'=>$products]);
});

Route::get('hello', function ()
{
    return "Hello World";
});

Route::get('helloworld', function ()
{
    return view('helloworld');
});

Route::get('/test', 'TestController@test2');

Route::post('/whoami','WhatsMyNameController@index'); 
Route::get('/askme', function () { return view('whoami'); });
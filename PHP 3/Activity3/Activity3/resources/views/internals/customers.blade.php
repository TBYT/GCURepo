@extends('layouts/layout')
@section('content')

<h1>Customers</h1>
<ul>
	<?php 
	/* foreach ($customers_arr as $customer)
	{
	    echo '<li>' . $customer . '<li>';
	} */
	?>
	
	@foreach ($customers_arr as $customer)
		<li>{{ $customer }}</li>
	@endforeach
</ul>

@endsection
<html>
	<head>
		<title>Add Order</title>
	</head>
	<body>
		<div>
			<form action="addorder" method="post">
				{{ csrf_field() }}
				<!-- Begin Demo Table -->
				<div class="demo-table">
					<div class="form-head">Order Product</div>
					<!-- Begin Product -->
					<div class="field-column">
						<div>
							<label for="product">Product</label><span id="product_info"class="error-info"></span>
						</div>
						<div>
							<input name="product"id="product" type="text"class="demo-input-box">
							<?php // echo $errors->first('user_name')?>
						</div>
					</div>
					<!-- End Product -->
					<!-- Begin CustomerID -->
					<div class="field-column">
						<div>
							<label for="customerID">Customer ID</label><span id="customerid_info"class="error-info"></span>
						</div>
						<div>
							<input name="customerID"id="customerID" value="{{ Session::get('nextID') }}" type="text"class="demo-input-box">
							<?php //echo $errors->first('password')?>
						</div>
						<div>
							<input name="firstName"id="firstName" value="{{ Session::get('firstName') }}" type="text"class="demo-input-box">
						</div>
						<div>
							<input name="lastName"id="lastName" value="{{ Session::get('lastName') }}" type="text"class="demo-input-box">
						</div>
					</div>
					<!-- End CustomerID -->
				</div>
				<!-- End Demo Table -->
				<div class="field-column">
					<input type="submit" class="btnLogin">
				</div>
			</form>
		</div>
	</body>
</html>

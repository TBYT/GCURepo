<html>
	<head>
		<title>Add Customer</title>
	</head>
	<body>
		<div>
			<form action="addcustomer" method="post">
				{{ csrf_field() }}
				<!-- Begin Demo Table -->
				<div class="demo-table">
					<div class="form-head">Add Customer</div>
					<!-- Begin Username -->
					<div class="field-column">
						<div>
							<label for="firstName">First Name</label><span id="firstName_info"class="error-info"></span>
						</div>
						<div>
							<input name="firstName"id="firstName" type="text"class="demo-input-box">
							<?php // echo $errors->first('user_name')?>
						</div>
					</div>
					<!-- End Username -->
					<!-- Begin Password -->
					<div class="field-column">
						<div>
							<label for="lastName">Last Name</label><span id="lastname_info"class="error-info"></span>
						</div>
						<div>
							<input name="lastName"id="lastName" type="text"class="demo-input-box">
							<?php //echo $errors->first('password')?>
						</div>
					</div>
					<!-- End Password -->
				</div>
				<!-- End Demo Table -->
				<div class="field-column">
					<input type="submit" class="btnLogin">
				</div>
			</form>
		</div>
	</body>
</html>

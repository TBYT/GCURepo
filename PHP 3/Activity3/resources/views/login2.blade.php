@extends('layouts.appmaster')
@section('title', 'Login Page')
@section('content')
    <!-- Note Shown: Insert your Login Form from login.php Here -->
<html>
	<head>
		<title>User Login</title>
	</head>
	<body>
		<div>
			<form action="dologin"method="post">
				{{ csrf_field() }}
				<!-- Begin Demo Table -->
				<div class="demo-table">
					<div class="form-head">Login</div>
					<!-- Begin Username -->
					<div class="field-column">
						<div>
							<label for="username">Username</label><span id="user_info"class="error-info"></span>
						</div>
						<div>
							<input name="user_name"id="user_name" type="text"class="demo-input-box"><?php echo $errors->first('username')?>
						</div>
					</div>
					<!-- End Username -->
					<!-- Begin Password -->
					<div class="field-column">
						<div>
							<label for="password">Password</label><span id="password_info"class="error-info"></span>
						</div>
						<div>
							<input name="password"id="password" type="password"class="demo-input-box"><?php echo $errors->first('password')?>
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

@endsection
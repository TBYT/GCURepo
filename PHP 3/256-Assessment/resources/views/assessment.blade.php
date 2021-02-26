<html>
	<head>
		<title>Assessment Form</title>
	</head>
	<body>
		<div>
			<form action="postassessment" method="post">
				{{ csrf_field() }}
				<!-- Begin Demo Table -->
				<div class="demo-table">
					<div class="form-head">Assessment</div>
					<!-- Begin Product -->
					<div class="field-column">
						<div>
							Name: <input required name="name"id="name" value="{{ $data[0] }}" type="text" class="demo-input-box"><br/>
							Years of Experience: <input required name="years"id="years" value="{{ $data[1] }}" type="number"class="demo-input-box"><br/>
							Email: <input name="email"id="email" required value="{{ $data[2] }}" type="email""demo-input-box"><br/>
							Url: <input required name="url"id="url" value="{{ $data[3] }}" type="url"class="demo-input-box"><br/>
						</div>
					</div>
					<!-- End CustomerID -->
				</div>
				<!-- End Demo Table -->
				<div class="field-column">
					<input type="submit">
				</div>
				<br/><?php echo $data[4]?>
			</form>
		</div>
	</body>
</html>

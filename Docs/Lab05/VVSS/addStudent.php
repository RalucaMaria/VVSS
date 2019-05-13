<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet"-->
    <link rel="stylesheet" href="main.css">
</head>
<body>
<div class="container">

	<div class="row">

	    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form name="myForm" role="form"  action="add.php" method="post" autocomplete="off">
				<h2>Please Add</h2>
			
				<hr>

				<div class="form-group">
					<input type="text" name="nume" id="nume" class="form-control input-lg" placeholder="nume" tabindex="1">
				</div>

				<div class="form-group">
					<input type="text" name="prenume" id="prenume" class="form-control input-lg" placeholder="prenume" tabindex="2">
				</div>
				
				<div class="form-group">
					<input type="number" name="varsta" id="varsta" class="form-control input-lg" placeholder="varsta" tabindex="4">
				</div>
				
				
				<hr>
				<div class="row">
					<div class="col-xs-6 col-md-6"><input type="submit" name="submit" value="Add" class="btn btn-primary btn-block btn-lg" tabindex="5"></div>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>
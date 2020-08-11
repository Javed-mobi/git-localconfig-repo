<!DOCTYPE html>
<html>

<head>
<title>Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body, html {
	height: 100%;
	background-color: #f5f6f8;
	background-image: url('bg.jpg');
	background-repeat: no-repeat;
	background-size: 50% auto;
	background-position: center right;
}

.login_box {
	padding-left: 15px;
	margin-bottom: 25px;
}

.input_title {
	color: rgba(164, 164, 164, 0.9);
	padding-left: 3px;
	margin-bottom: 2px;
	font-size: 13px;
}

hr {
	width: 100%;
}

.welcome {
	font-family: "myriad-pro", sans-serif;
	font-style: normal;
	font-weight: 100;
	color: #FFFFFF;
	margin-bottom: 75px;
	margin-top: 150px;
}

.login_title {
	font-family: 'Roboto', sans-serif;
	font-style: normal;
	color: #555;
	margin-bottom: 23px;
	font-size: 18px;
	font-weight: 600;
}

.card-container.card {
	max-width: 350px;
}

.btn {
	font-weight: 700;
	-moz-user-select: none;
	-webkit-user-select: none;
	user-select: none;
	cursor: default;
	background-color: #1565d8;
	margin-bottom: 10px;
	padding: 0;
	font-size: 14px;
	height: 36px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: none;
	-o-transition: all 0.218s;
	-moz-transition: all 0.218s;
	-webkit-transition: all 0.218s;
	transition: all 0.218s;
}

/*
  * Card component
  */
.card {
	/* just in case there no content*/
	padding: 1px 25px 30px;
	margin: 0 auto 25px;
	margin-top: 15px;
}

.profile-img-card {
	width: 96px;
	height: 96px;
	margin: 0 auto 10px;
	display: block;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
}

/*
  * Form styles
  */
.profile-name-card {
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	margin: 10px 0 0;
	min-height: 1em;
}

.reauth-email {
	display: block;
	color: #404040;
	line-height: 2;
	margin-bottom: 10px;
	font-size: 14px;
	text-align: center;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin #inputEmail, .form-signin #inputPassword {
	direction: ltr;
	height: 38px;
	font-size: 14px;
	background-color: inherit;
	border: 1px solid #a5a6a8;
	border-radius: 3px;
}

.form-signin input[type=email], .form-signin input[type=password],
	.form-signin input[type=text], .form-signin button {
	width: 100%;
	display: block;
	z-index: 1;
	position: relative;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	border-color: rgb(104, 145, 162);
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col col-md-6">

				<div class="card card-container">
					<h1 class="welcome">
						<img src="admin_logo.png" alt="">
					</h1>
					<h2 class='login_title'>Login to your account</h2>
					<form class="form-signin" action="login" method="POST">
						<p class="input_title">Email</p>
						<input type="text" id="username" name="username" class="login_box"
							placeholder="email/ username" required autofocus>
						<p class="input_title">Password</p>
						<input type="password" id="password" name="password"
							class="login_box" placeholder="password" required>
						<button class="btn btn-lg btn-primary btn-signin" type="submit">Login</button>
					</form>
					<!-- /form -->
				</div>
				<!-- /card-container -->
			</div>
		</div>

	</div>
	<!-- /container -->

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.4.0/bootbox.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
	<script>
    jQuery(document).ready(($) => {
    });
  </script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- awal bootstrap 3 -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- akhir bootstrap 3 -->

<!-- client validasi -->
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- awal jquery datatables untuk bootstrap 3 -->

<!-- <script src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>

<script src="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" /> -->

<!-- akhir jquery datatables untuk bootstrap 3 -->

<!-- awal datepicker -->

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
<link
	href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<!-- akhir datepicker -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilex"%>

	<tilex:useAttribute name="current" />

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/" />">Spring
						MVC</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : '' }"><a
							href="<spring:url value="/" />">Home</a></li>
						<li class="${current == 'mstKonfig' ? 'active' : '' }"><a
							href="<spring:url value="/konfig/list.html" />">Master Konfigurasi</a></li>	
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<tiles:insertAttribute name="body" />
		<br> <br>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>

</body>
</html>
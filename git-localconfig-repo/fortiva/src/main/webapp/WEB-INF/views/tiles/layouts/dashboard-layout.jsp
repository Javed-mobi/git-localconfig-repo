<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
<meta charset="utf-8">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<script type="text/javascript">
			function openScreen(screenUrl) {
				var shopId = document.getElementById('shopId').value;
				window.location = screenUrl + "?shopId=" + shopId;
			}
		</script>
</head>

<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<c:if test="${saveFlag}">
			<div class="row">
				<div class="alert alert-success fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success! </strong>data has been saved successfully.
				</div>
			</div>
		</c:if>
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
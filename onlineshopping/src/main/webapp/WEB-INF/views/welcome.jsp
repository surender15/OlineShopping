<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:set var="contextRoot" value="${pageContext.request.contextPath }" />
 --%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>

<script>
	window.menu = '${title}';
</script>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
 

<!-- Custom styles for this template -->
<link href="css/myapp.css" rel="stylesheet">

</head> 

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>



		<!-- Page Content -->
		<div class="content">

			<!-- Loading the home page -->
			<!-- Load the home page when the user clicks home button -->
			<c:if test="${userClickHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>

			<!-- Load the About page when the user clicks About button -->
			<c:if test="${userClickAbout == true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<!-- Load the contact page when the user clicks contact button -->
			<c:if test="${userClickContact == true}">
				<%@include file="./contact.jsp"%>
			</c:if>
		</div>


		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/myapp.js"></script>
	</div>
</body>

</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">

	<div class="row">
		<!-- Would be to display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added Breadcrumb component -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickAllProducts==true}">
					<script>
						window.categoryId=''
					</script>
					
						<ol class="breadcrumb">
							<li><a href="/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts==true}">
					<script>
						window.categoryId='${category.id}'
					</script>
					
						<ol class="breadcrumb">
							<li><a href="/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

		
			<div class="row">
				<div class="col-md-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
							    <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>
	</div>

</div>



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
					<c:if test="${userClicktest==true}">
						<ol class="breadcrumb">
							<li><a href="/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

				

				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>

								<th>TD</th>
								<th>Name</th>

							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>
	</div>

</div>


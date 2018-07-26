
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<!-- Breadcrumb -->

	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="/home">Home</a></li>
				<li><a href="/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>

	</div>

	<div class="row">

		<!-- Display the product Image  -->

		<div class="col-xs-4">
			<div class="thumbnail">
				<img src="../../../../images/${product.code}.jpg"
					class="img img-responsive viewImg">
			</div>
		</div>

		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			</hr>
			<p>${product.description}</p>
			</hr>
			<h4>
				Price:<strong> &#8377;${product.unitPrice} /-</strong>
			</h4>
			</hr>

			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>
						Qty.Available :<span style="color: red">Out of stock!</span>
					</h6>
					</hr>
				</c:when>

				<c:otherwise>
					<h6>Qty.Available :${product.quantity}</h6>
					</hr>
				</c:otherwise>

			</c:choose>

			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a href="/home" class="btn btn-success">Home</a> &#160;
						<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span
							class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>

				</c:when>
				<c:otherwise>
					<a href="/home" class="btn btn-success">Home</a> &#160; <a
						href="/cart/add/${product.id}/product" class="btn btn-success"><span
						class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
				</c:otherwise>

			</c:choose>
		</div>

	</div>
</div>
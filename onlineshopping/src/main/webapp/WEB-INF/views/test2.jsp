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
					<c:if test="${userClicktestCategoryTest == true}">
						<ol class="breadcrumb">
							<li class="active">Category/</li>
							<li>${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
		</div>
	</div>

</div>


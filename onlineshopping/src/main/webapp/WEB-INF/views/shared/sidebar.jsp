<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="list-group">
			<c:forEach items="${categories}" var="category">
			    <a href="#" class="list-group-item">${category.name}</a>
			</c:forEach>
</div>

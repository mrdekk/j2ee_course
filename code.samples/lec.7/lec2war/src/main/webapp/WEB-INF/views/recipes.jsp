<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />

		<title>Список рецептов</title>

		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Переключить навигацию</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
          			</button>
					<a class="navbar-brand" href="#">Рецепты</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>
		
		<div class="container">
		
			<div class="row" >
				<div class="col-lg-3" >
					<ul data-bind="foreach: recipes" >
						<li><a href="#" data-bind="text: name, click: $root.viewRecipe"></a></li>
					</ul>
				</div>
				
				<div class="col-lg-9" >
					<table class="table table-striped table-hover" >
						<thead>
							<tr>
								<th>#</th>
								<th>Компонент</th>
								<th>Количество</th>
							</tr>
						</thead>
						<tbody data-bind="foreach: ingredients" >
							<tr>
								<td data-bind="text: $index() + 1" ></td>
								<td data-bind="text: component" ></td>
								<td data-bind="text: quantity" ></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>			

		</div><!-- /.container -->

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/knockout-3.4.0.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/main.js" ></script>
		
		<div style="display: none;" >
			<div id="baseUrl" >${pageContext.request.contextPath}</div>
		</div>
	</body>
</html>
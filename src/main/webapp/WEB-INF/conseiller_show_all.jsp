<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Gestion de conseiller</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
						<li class="nav-header">Gestion de conseiller</li>
						<li><a href="ShowConseillersServlet">Lister all
								conseillers</a></li>
						<li><a href="UpdateConseillerServlet">Ajouter un
								conseiller</a></li>
						<li class="divider"></li>
						<li><a href="DoAuditServlet">Audit d'agence</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<strong class="msg-info">${msg}</strong> <br>
				<h3>Les conseillers geres par vous :</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Reference employee</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Adresse</th>
							<th></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${conseillerList}" var="conseiller">
							<tr>
								<td>${conseiller.refEmployee}</td>
								<td>${conseiller.nom}</td>
								<td>${conseiller.prenom}</td>
								<td>${conseiller.adresse.toString()}</td>
								<td><a href="UpdateConseillerServlet?id=${conseiller.id}"
									class="view-link">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li class="next"><a href="">Plus &rarr;</a></li>
				</ul>

			</div>
		</div>
	</div>
</body>
</html>
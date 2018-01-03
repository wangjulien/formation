<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">

						<c:choose>

							<c:when test="${user.role eq 'C'.charAt(0)}">

								<li class="nav-header">Gestion de client</li>
								<li><a href="ShowClientsServlet">Lister all clients</a></li>
								<li><a href="UpdateClientServlet">Ajouter un client</a></li>
								<li class="divider"></li>
								<li><a href="GestionCompteServlet">Gestion de compte</a></li>
								<li><a href="under_construction.html">Gestion de carte</a></li>
								<li class="divider"></li>
								<li><a href="VirementServlet">Virement</a></li>
								<li><a href="under_construction.html">Histories de virements</a></li>

							</c:when>

							<c:when test="${user.role eq 'G'.charAt(0)}">

								<li class="nav-header">Gestion de conseiller</li>
								<li><a href="ShowConseillersServlet">Lister all conseillers</a></li>
								<li><a href="UpdateConseillerServlet">Ajouter un conseiller</a></li>
								<li class="divider"></li>
								<li><a href="under_construction.html">Audit d'agence</a></li>
							</c:when>

						</c:choose>
					</ul>
				</div>
			</div>
			<div class="span9">
				<h3>Bienvenu ${user.nom} ${user.prenom}</h3>
				<img src="img/weclome.gif"  class="img-thumbnail" />
			</div>
		</div>

	</div>

</body>
</html>
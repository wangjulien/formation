<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="index.html">Proxi Banque</a>

					<div class="nav-collapse">
						<ul class="nav">

							<c:choose>
								
								<c:when test="${user.role eq 'C'.charAt(0)}">
									<li class="dropdown"><a href="ShowClientsServlet"
										class="dropdown-toggle" data-toggle="dropdown">Gestion de
											client<b class="caret"></b>
									</a>
										<ul class="dropdown-menu">
											<li><a href="ShowClientsServlet">Lister all
													clients</a></li>
											<li><a href="UpdateClientServlet">Ajouter un client</a></li>
											<li class="divider"></li>
											<li><a href="GestionCompteServlet">Gestion de compte</a></li>
											<li><a href="under_construction.html">Gestion de carte</a></li>
										</ul></li>
									<li><a href="VirementServlet">Virement</a></li>
									
								</c:when>
								
								<c:when test="${user.role eq 'G'.charAt(0)}">
									<li class="dropdown"><a href="ShowConseillersServlet"
										class="dropdown-toggle" data-toggle="dropdown">Gestion de
											conseiller<b class="caret"></b>
									</a>
										<ul class="dropdown-menu">
											<li><a href="ShowConseillersServlet">Lister all
													conseillers</a></li>
											<li><a href="UpdateConseillerServlet">Ajouter un
													conseiller</a></li>
										</ul></li>
									<li><a href="under_construction.html">Audit d'agence</a></li>
								</c:when>
								
							</c:choose>

						</ul>
						<ul class="nav pull-right">
							<li><a href="under_construction.html">${user.nom} ${user.prenom}</a></li>
							<li><a href="LogoutServlet">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>
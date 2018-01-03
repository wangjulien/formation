<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Mettre a jour un conseiller</title>
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
						<li><a href="under_construction.html">Audit d'agence</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div id="login-page" class="container">
					<strong class="msg-info">${msg}</strong> <br>

					<h3>Conseiller information :</h3>
					<form class="well" action="UpdateConseillerServlet" method="post">
						<table>
							<tr>
								<td>Reference Employee : <br>(Laissez vide si vous
									voulez generation auto)<br> <input type="text" name="ref"
									value="${conseiller.refEmployee}" />
								</td>
							</tr>
							<tr>
								<td>Prenom : <br> <input type="text" name="prenom"
									value="${conseiller.getPrenom()}" />
								</td>
							</tr>
							<tr>
								<td>Nom : <br> <input type="text" name="nom"
									value="${conseiller.getNom()}" />
								</td>
							</tr>
							<tr>
								<td>Rue : <br> <input type="text" name="rue"
									value="${conseiller.adresse.rue}" />
								</td>
							</tr>
							<tr>
								<td>Code Postal : <br> <input type="text"
									name="codepostal" value="${conseiller.adresse.codePostal}" />
								</td>
							</tr>
							<tr>
								<td>Ville : <br> <input type="text" name="ville"
									value="${conseiller.adresse.ville}" />
								</td>
							</tr>
							<tr>
								<td>Tel : <br> <input type="text" name="tel"
									value="${conseiller.adresse.tel}" />
								</td>
							</tr>
							<c:choose>
								<c:when test="${empty conseiller}">
									<tr>
										<td><input type="submit" value="Ajouter"
											class="btn btn-primary" /></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td><input type="submit" value="Mettre a jour"
											class="btn btn-primary" /></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
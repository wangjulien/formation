<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Gestion de client</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
						<li class="nav-header">Gestion de client</li>
						<li><a href="ShowClientsServlet">Lister all clients</a></li>
						<li><a href="UpdateClientServlet">Ajouter un client</a></li>
						<li class="divider"></li>
						<li><a href="GestionCompteServlet">Gestion de compte</a></li>
						<li><a href="GestionCarteServlet">Gestion de carte</a></li>
						<li class="divider"></li>
						<li><a href="VirementServlet">Virement</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<strong class="msg-info">${msg}</strong> <br>
				<h3>Les clients particuliers geres par vous :</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Reference</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Solde Compte Courant</th>
							<th>Solde Compte Epargne</th>
							<th></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientParticulierList}" var="client">
							<tr>
								<td>${client.refClient}</td>
								<td>${client.nom}</td>
								<td>${client.prenom}</td>
								<td><c:choose>
										<c:when test="${client.compteCourant.etatActif}">
								${client.compteCourant.solde}
								</c:when>
										<c:otherwise>
											Non active (<a
												href="GestionCompteServlet?id=${client.id}&type=courant"
												class="view-link">Activer</a>)
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${client.compteEpargne.etatActif}">
								${client.compteEpargne.solde}
								</c:when>
										<c:otherwise>
											Non active (<a
												href="GestionCompteServlet?id=${client.id}&type=epargne"
												class="view-link">Activer</a>)
										</c:otherwise>
									</c:choose></td>
								<td><a href="UpdateClientServlet?id=${client.id}"
									class="view-link">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li class="next"><a href="">Plus &rarr;</a></li>
				</ul>

				<h3>Les clients entreprises geres par vous :</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Reference</th>
							<th>Raison Sociale</th>
							<th>Numero Siret</th>
							<th>Solde Compte Courant</th>
							<th>Solde Compte Epargne</th>
							<th></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientEntrepriseList}" var="client">
							<tr>
								<td>${client.refClient}</td>
								<td>${client.nomSociete}</td>
								<td>${client.noSiret}</td>
								<td><c:choose>
										<c:when test="${client.compteCourant.etatActif}">
								${client.compteCourant.solde}
								</c:when>
										<c:otherwise>
											Non active (<a
												href="GestionCompteServlet?id=${client.id}&type=courant"
												class="view-link">Activer</a>)
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${client.compteEpargne.etatActif}">
								${client.compteEpargne.solde}
								</c:when>
										<c:otherwise>
											Non active (<a
												href="GestionCompteServlet?id=${client.id}&type=epargne"
												class="view-link">Activer</a>)
										</c:otherwise>
									</c:choose></td>
								<td><a href="UpdateClientServlet?id=${client.id}"
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
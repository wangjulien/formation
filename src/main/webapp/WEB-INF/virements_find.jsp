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
						<li class="nav-header">Gestion de client</li>
						<li><a href="ShowClientsServlet">Lister all clients</a></li>
						<li><a href="UpdateClientServlet">Ajouter un client</a></li>
						<li class="divider"></li>
						<li><a href="GestionCompteServlet">Gestion de compte</a></li>
						<li><a href="GestionCarteServlet">Gestion de carte</a></li>
						<li class="divider"></li>
						<li><a href="VirementServlet">Virement</a></li>
						<li><a href="ShowVirementServlet">Histories de virements</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<strong class="msg-info">${msg}</strong> <br>
				<h3>Lister tous les virements effectues par le client</h3>
				<form class="well" action="VirementServlet" method="post">
						<table>
							<tr>
								<td>
								<label for="name">Selectionnez un client : </label>
								<select class="form-control"  name="debiteurselect" id="debiteurselect" onchange="this.form.submit()">
									<c:forEach items="${clientList}" var="client">
										<option value="${client.id}">
										${client.getNom()} ${client.getPrenom()} (${client.refClient})
										</option>
									</c:forEach>
								</select></td>
								</tr>
								</table>
				
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							
							<th>Numero de compte debiteur</th>
							<th>Numero de compte crediteur</th>
							<th>Montant transfert</th>
							<th>Date d'operation</th>
							<th></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${virementsList}" var="virement">
							<tr>
								<td>${virement.depart.toString()}</td>
								<td>${virement.cible.toString()}</td>
								<td>${virement.montant}</td>
								<td>${virement.dateOperation}</td>
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
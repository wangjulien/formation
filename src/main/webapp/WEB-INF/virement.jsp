<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Virement compte a compte</title>
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
						<li><a href="under_construction.html">Gestion de carte</a></li>
						<li class="divider"></li>
						<li><a href="VirementServlet">Virement</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div id="login-page">
					<strong class="msg-info">${msg}</strong> <br>
					<h3>Effectuer un virement :</h3>

					<form class="well" action="VirementServlet" method="post">
						<table>
							<tr>
								<td><label for="listeClientSelect">Selectionnez un
										debiteur</label> <select class="form-control" name="listeClientSelect">
										<c:forEach items="${clientList}" var="client">
											<c:if test="${client.compteCourant.etatActif}">
												<option value="${client.id}-courant">(${client.refClient})
													${client.getNom()} ${client.getPrenom()} Compte Courant :
													${client.compteCourant.solde}</option>
											</c:if>
											<c:if test="${client.compteEpargne.etatActif}">
												<option value="${client.id}-epargne">(${client.refClient})
													${client.getNom()} ${client.getPrenom()} Compte Epargne :
													${client.compteEpargne.solde}</option>
											</c:if>
										</c:forEach>
								</select></td>
							</tr>

							<tr>
								<td><label for="debiteurselect">Selectionnez un
										debiteur : </label> <select class="form-control" name="debiteurselect"
									id="debiteurselect" disabled>
										<c:forEach items="${clientList}" var="client">
											<option value="${client}">${client.getNom()}
												${client.getPrenom()} (${client.refClient})</option>
										</c:forEach>
								</select></td>
								<td><label for="debcomptselect">Selectionnez son
										compte a debiter : </label> <select class="form-control"
									name="debcomptselect" id="debcomptselect" disabled>
										<option value="courant">Compte Courant</option>
										<option value="epargne">Compte Epargne</option>
								</select></td>
							</tr>

							<tr>
								<td><label for="listeAllClientSelect">Selectionnez
										un crediteur</label> <select class="form-control"
									name="listeAllClientSelect">
										<c:forEach items="${allClientList}" var="client">
											<c:if test="${client.compteCourant.etatActif}">
												<option value="${client.id}-courant">(${client.refClient})
													${client.getNom()} ${client.getPrenom()} Compte Courant :
													${client.compteCourant.solde}</option>
											</c:if>
											<c:if test="${client.compteEpargne.etatActif}">
												<option value="${client.id}-epargne">(${client.refClient})
													${client.getNom()} ${client.getPrenom()} Compte Epargne :
													${client.compteEpargne.solde}</option>
											</c:if>
										</c:forEach>
								</select></td>
							</tr>

							<tr>
								<td><label for="crediteurselect">Selectionnez un
										crediteur : </label> <select class="form-control"
									name="crediteurselect" id="crediteurselect" disabled>
										<c:forEach items="${allClientList}" var="client">
											<option value="${client.id}">${client.getNom()}
												${client.getPrenom()} (${client.refClient})</option>
										</c:forEach>
								</select></td>
								<td><label for="crdcomptselect">Selectionnez son
										compte a debiter : </label> <select class="form-control"
									name="crdcomptselect" id="crdcomptselect" disabled>
										<option value="courant">Compte Courant</option>
										<option value="epargne">Compte Epargne</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="text" name="montant"
									placeholder="Saisissez le montant" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Effectuer"
									class="btn btn-primary" /> <a href="ShowClientsServlet">
										Annuler </a></td>
							</tr>
						</table>
					</form>

					<c:if
						test="${not empty debiteur && not empty crediteur && not empty montant}">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Debiteur</th>
									<th>Nouveau Solde</th>
									<th>Crediteur</th>
									<th>Nouveau Solde</th>
									<th>Montant vire</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${debiteur.nom}${debiteur.prenom}</td>

									<td>${depart.solde}</td>

									<td>${crediteur.nom}${crediteur.prenom}</td>

									<td>${cible.solde}</td>

									<td>${montant}</td>
								</tr>
							</tbody>
						</table>

					</c:if>

				</div>
			</div>
		</div>
	</div>
</body>

<script src="js/jquery.min.js"></script>
<script>
	$('#debiteurselect').on('change', function() {
		//         $(this).val()
		//         $("#debcomptselect").text("Compte Courant JS")

	});
</script>

</html>
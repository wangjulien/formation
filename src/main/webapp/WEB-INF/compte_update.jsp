<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Insert title here</title>
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
					</ul>
				</div>
			</div>
			<div class="span9">
				<div id="login-page">
					<strong class="msg-info">${msg}</strong> <br>
					<h3>Compte information :</h3>
					<form class="well" action="GestionCompteServlet" method="post">
						<table>

							<c:choose>
								<c:when test="${not empty clientList}">
									<tr>
										<td><label for="name">Selectionnez un client et
												son compte</label> <select class="form-control">
												<c:forEach items="${clientList}" var="client">

													<option value="${client.compteCourant.id}">(${client.refClient})
														${client.getNom()} ${client.getPrenom()}
														<c:if test="${client.compteCourant.etatActif}">
												Compte Courant : ${client.compteCourant.numCompte}
											</c:if>
													</option>
													<option value="${client.compteEpargne.id}">(${client.refClient})
														${client.getNom()} ${client.getPrenom()}
														<c:if test="${client.compteEpargne.etatActif}">
												Compte Epargne : ${client.compteEpargne.numCompte}
											</c:if>
													</option>

												</c:forEach>
										</select></td>
									</tr>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when
									test="${not empty compteCourant || not empty compteEpargne}">

									<c:if test="${not empty compteCourant}">
										<input type="hidden" name="type" value="courant">
										<tr>
											<td>Numero compte : <br> <input type="text"
												name="numcompte" value="CC000${compteCourant.id}" />
											</td>
										</tr>
										<tr>
											<td>Solde : <br> <input type="text" name="solde"
												value="${compteCourant.solde}" />
											</td>
										</tr>
										<tr>
											<td>Decouvert Authorise : <br> <input type="text"
												name="decouvert" value="${compteCourant.decouvertAuthorise}" />
											</td>
										</tr>
									</c:if>

									<c:if test="${not empty compteEpargne}">
										<input type="hidden" name="type" value="epargne">
										<tr>
											<td>Numero compte : <br> <input type="text"
												name="numcompte" value="CE000${compteEpargne.id}" />
											</td>
										</tr>
										<tr>
											<td>Solde : <br> <input type="text" name="solde"
												value="${compteEpargne.solde}" />
											</td>
										</tr>
										<tr>
											<td>Taux Interet : <br> <input type="text"
												name="taux" value="${compteEpargne.tauxInteret}" />
											</td>
										</tr>
									</c:if>

								</c:when>
							</c:choose>

							<tr>
								<td><input type="submit" value="Mettre a jour"
									class="btn btn-primary" /> <a href="ShowClientsServlet">
										Annuler </a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
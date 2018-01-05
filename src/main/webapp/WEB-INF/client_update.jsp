<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/site.css" />
<title>Mettre a jour un client</title>
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
				<div id="edit-page" class="container">
					<strong class="msg-info">${msg}</strong> <br>

					<h3>Client information :</h3>
					<form class="well" action="UpdateClientServlet" method="post">
						<table>
							<c:if test="${empty client}">
								<tr>
									<td><input type="radio" name="typeclient"
										value="particulier" checked> Client Particulier <br></td>
								</tr>
								<tr>
									<td><input type="radio" name="typeclient"
										value="entreprise"> Client Entreprise<br></td>
								</tr>
							</c:if>

							<tr>
								<td>Reference : <br>(Laissez vide si vous voulez
									generation auto)<br> <input type="text" name="ref"
									value="${client.refClient}" />
								</td>
							</tr>
							<tr>
								<td>Prenom / Siret : <br> <input type="text"
									name="prenom" value="${client.getPrenom()}" />
								</td>
							</tr>
							<tr>
								<td>Nom / Raison Sociale : <br> <input type="text"
									name="nom" value="${client.getNom()}" />
								</td>
							</tr>
							<tr>
								<td>Rue : <br> <input type="text" name="rue"
									value="${client.adresse.rue}" />
								</td>
							</tr>
							<tr>
								<td>Code Postal : <br> <input type="text"
									name="codepostal" value="${client.adresse.codePostal}" />
								</td>
							</tr>
							<tr>
								<td>Ville : <br> <input type="text" name="ville"
									value="${client.adresse.ville}" />
								</td>
							</tr>
							<tr>
								<td>Tel : <br> <input type="text" name="tel"
									value="${client.adresse.tel}" />
								</td>
							</tr>

							<tr>
								<td><c:if test="${client.compteCourant.etatActif}">

										<table>
											<tr>
												<td><h3>Compte Courant :</h3> <input type="hidden"
													name="courant" value="true"></td>
											</tr>
											<tr>
												<td>Date d'ouverture : <br> <input type="text"
													name="date" value="${client.compteCourant.dateOuverture}"
													disabled />
												</td>
											</tr>
											<tr>
												<td>Numero compte : <br> <input type="text"
													name="numcompte" value="${client.compteCourant.numCompte}" />
												</td>
											</tr>
											<tr>
												<td>Solde : <br> <input type="text" name="solde"
													value="${client.compteCourant.solde}" />
												</td>
											</tr>
											<tr>
												<td>Decouvert Authorise : <br> <input type="text"
													name="decouvert"
													value="${client.compteCourant.decouvertAuthorise}" />
												</td>
											</tr>
										</table>
									</c:if> 
									</td><td>
									<c:if test="${client.compteEpargne.etatActif}">

										<table>
											<tr>
												<td><h3>Compte Epargne :</h3> <input type="hidden"
													name="epargne" value="true"></td>
											</tr>
											<tr>
											<tr>
												<td>Date d'ouverture : <br> <input type="text"
													name="date" value="${client.compteEpargne.dateOuverture}"
													disabled />
												</td>
											</tr>
											<tr>
												<td>Numero compte : <br> <input type="text"
													name="numcompte" value="${client.compteEpargne.numCompte}" />
												</td>
											</tr>
											<tr>
												<td>Solde : <br> <input type="text" name="solde"
													value="${client.compteEpargne.solde}" />
												</td>
											</tr>
											<tr>
												<td>Taux Interet : <br> <input type="text"
													name="taux" value="${client.compteEpargne.tauxInteret}" />
												</td>
											</tr>
										</table>
									</c:if></td>
							</tr>

							<c:choose>
								<c:when test="${empty client}">
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
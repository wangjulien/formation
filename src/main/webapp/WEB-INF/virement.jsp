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
						<li><a href="GestionCarteServlet">Gestion de carte</a></li>
						<li class="divider"></li>
						<li><a href="VirementServlet">Virement</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div id="login-page">
					<strong class="msg-info">${msg}</strong> <br>
					<h3>Compte information :</h3>
					<form class="well" action="VirementServlet" method="post">
						<table>
							<tr>
								<td>
								<label for="name">Selectionnez un debiteur : </label>
								<select class="form-control"  name="debiteurselect" id="debiteurselect" onchange="this.form.submit()">
									<c:forEach items="${clientList}" var="client">
										<option value="${client.id}">
										${client.getNom()} ${client.getPrenom()} (${client.refClient})
										</option>
									</c:forEach>
								</select></td>
								<td>
								<label for="name">Selectionnez son compte a debiter : </label>
								<select class="form-control"  name="debcomptselect" id="debcomptselect">
										<option value="courant">Compte Courant</option>
										<option value="epargne">Compte Epargne</option>									
								</select></td>
							</tr>
							<tr>
								<td>
								<label for="name">Selectionnez un crediteur : </label>
								<select class="form-control"  name="crediteurselect" id="crediteurselect" onchange="this.form.submit()">
									<c:forEach items="${allClientList}" var="client">
										<option value="${client.id}">
										${client.getNom()} ${client.getPrenom()} (${client.refClient})
										</option>
									</c:forEach>
								</select></td>
								<td>
								<label for="name">Selectionnez son compte a debiter : </label>
								<select class="form-control"  name="crdcomptselect" id="crdcomptselect">
										<option value="courant">Compte Courant</option>
										<option value="epargne">Compte Epargne</option>									
								</select></td>
							</tr>
							<tr>
								<td><input type="text" name="montant" placeholder="Saisissez le montant" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Effectuer"
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

<script src="js/jquery.min.js"></script>
<script>  
$('#debiteurselect').on('change',function(){
        $(this).selectedIndex
        $("#debcomptselect").text("Compte Courant JS")
        
    });
</script>

</html>
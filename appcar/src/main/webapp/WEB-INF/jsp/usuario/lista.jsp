<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>AppLanche</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<form action="/usuario" method="get">
			<h3>Listagem de Usu�rio</h3>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success">
					<strong>Aten��o!</strong> ${mensagem}
				</div>
			</c:if>

			<button type="submit">Novo</button>
		</form>

		<c:if test="${empty usuarios}">
			<h5>N�o existem usu�rios cadastrados!!!</h5>
		</c:if>

		<c:if test="${not empty usuarios}">
			<h5>Quantidade de usu�rios cadastrados: ${usuarios.size()}!!!</h5>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Senha</th>
						<th>E-mail</th>
						<th>Caracter�sticas</th>
						<th>Tipo</th>
						<th>Setor</th>
						<th>Idade</th>
						<th>Sal�rio</th>
						<th>Admin</th>
						<th>Endere�o</th>
						<th>Solicitantes</th>
						<th>Veiculos</th>
						<th>Pedidos</th>
						<c:if test="${usuario.admin}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${usuarios}">
						<tr>
							<td>${u.id}</td>
							<td>${u.nome}</td>
							<td>${u.senha}</td>
							<td>${u.email}</td>
							<td>${u.caracteristicas}</td>
							<td>${u.tipo}</td>
							<td>${u.setor}</td>
							<td>${u.idade}</td>
							<td>${u.salario}</td>
							<td>${u.admin}</td>
							<td>${u.endereco}</td>
							<td>${u.solicitantes.size()}</td>
							<td>${u.veiculos.size()}</td>
							<td>${u.pedidos.size()}</td>
							<c:if test="${usuario.admin}">
								<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>
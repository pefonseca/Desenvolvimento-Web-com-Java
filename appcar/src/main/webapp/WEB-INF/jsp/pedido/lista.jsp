<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>Listagem de Pedidos</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <h3>Listagem de Pedidos</h3>

    <c:if test="${not empty mensagem}">
        <div class="alert alert-success">
            <strong>Atenção</strong> ${mensagem}
        </div>
    </c:if>

    <form action="/pedido" method="get">
        <button type="submit">Novo</button>
    </form>

    <c:if test="${empty pedidos}">
        <h5>Não existem pedidos cadastrados!!!</h5>
    </c:if>

    <c:if test="${not empty pedidos}">
        <h5>Quantidade de pedidos cadastrados: ${pedidos.size()}!!!</h5>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Web</th>
                <th>Data</th>
                <th>Solicitante</th>
                <th>Usuario</th>
                <th>Veiculos</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="p" items="${pedidos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.descricao}</td>
                    <td>${p.web}</td>
                    <td>${p.data}</td>
                    <td>${p.solicitante.nome}</td>
                    <td>${p.usuario.nome}</td>
                    <td>${p.veiculos.size()}</td>
                    <td><a href="/pedido/${p.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
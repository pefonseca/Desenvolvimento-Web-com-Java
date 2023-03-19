<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Listagem de Veículos</title>
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <form action="/veiculo" method="get">
        <h3>Listagem de Veículos</h3>

        <c:if test="${not empty mensagem}">
            <div class="alert alert-success">
                <strong>Atenção!</strong> ${mensagem}
            </div>
        </c:if>

        <button type="submit">Novo</button>
    </form>

    <c:if test="${empty veiculos}">
        <h5>Não existem veiculos cadastradas!!!</h5>
    </c:if>

    <c:if test="${not empty veiculos}">
        <h5>Quantidade de veiculos cadastrados: ${veiculos.size()}!!!</h5>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Cor</th>
                <th>Ano</th>
                <th>Marca</th>
                <th>Primeiro Dono</th>
                <th>Valor</th>
                <th>Quilometragem</th>
                <th>Usuario</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="v" items="${veiculos}">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.nome}</td>
                    <td>${v.cor}</td>
                    <td>${v.ano}</td>
                    <td>${v.marca}</td>
                    <td>${v.primeiroDono}</td>
                    <td>${v.valor}</td>
                    <td>${v.quilometragem}</td>
                    <td>${v.usuario.nome}</td>
                    <td><a href="/veiculo/${v.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
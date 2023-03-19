<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Listagem de Caminhões</title>
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <form action="/caminhao" method="get">
        <h3>Listagem de Caminhões</h3>

        <c:if test="${not empty mensagem}">
            <div class="alert alert-success">
                <strong>Atenção!</strong> ${mensagem}
            </div>
        </c:if>

        <button type="submit">Novo</button>
    </form>

    <c:if test="${empty caminhoes}">
        <h5>Não existem caminhões cadastrados!!!</h5>
    </c:if>

    <c:if test="${not empty caminhoes}">
        <h5>Quantidade de usuários cadastrados: ${caminhoes.size()}!!!</h5>
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
                <th>Carga</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${caminhoes}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.cor}</td>
                    <td>${c.ano}</td>
                    <td>${c.marca}</td>
                    <td>${c.primeiroDono}</td>
                    <td>${c.valor}</td>
                    <td>${c.quilometragem}</td>
                    <td>${c.carga}</td>
                    <td>${c.usuario.nome}</td>
                    <td><a href="/caminhao/${c.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
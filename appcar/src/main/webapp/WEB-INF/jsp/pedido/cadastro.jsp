<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>Cadastro de Pedidos</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <form action="/pedido/incluir" method="post">
        <h3>Cadastro de Pedidos</h3>

        <div class="form-group">
            <label>Descrição:</label>
            <input type="text" name="descricao" value="Primeiro Pedido Cadastrado" class="form-control">
        </div>

        <div class="form-group">
            <label>Caracteristicas:</label>
            <div class="form-check">
                <label class="form-check-label">
                    <input type="checkbox" name="web" value="true" class="form-check-input" > Atendimento Web
                </label>
            </div>
        </div>

        <div class="form-group">
            <label>Data:</label>
            <input type="date" name="data" class="form-control">
        </div>

<%--        <div class="form-group">--%>
<%--            <label>Solicitante:</label>--%>
<%--            <select name="solicitante" class="form-control">--%>
<%--                <c:forEach var="p" items="${pedidos}">--%>
<%--                    <option value="${p.solicitante.id}">--%>
<%--                        <tr>${p.solicitante.nome}</tr>--%>
<%--                    </option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>

        <button type="submit">Cadastrar</button>
    </form>
</div>
</body>
</html>
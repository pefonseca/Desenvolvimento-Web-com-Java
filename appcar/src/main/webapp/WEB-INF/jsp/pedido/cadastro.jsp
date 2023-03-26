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
<c:set var="botao" value=""/>

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

        <div class="form-group">
            <c:if test="${not empty solicitantes}">
                <label>Solicitante:</label>
                <select name="solicitante" class="form-control">
                    <c:forEach var="s" items="${solicitantes}">
                        <option value="${s.id}">${s.nome}</option>
                    </c:forEach>
                </select>
            </c:if>
            <c:if test="${empty solicitantes}">
                <c:set var="botao" value="disabled"/>
                <label>Não existem solicitantes cadastrados!</label>
            </c:if>
        </div>

        <div class="form-group">
            <c:if test="${not empty veiculos}">
                <label>Veiculos:</label>
                <c:forEach var="v" items="${veiculos}">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" name="veiculos" value="${v.id}" class="form-check-input"> ${v.nome}
                        </label>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty veiculos}">
                <c:set var="botao" value="disabled"/>
                <label>Não existem veiculos cadastrados!</label>
            </c:if>
        </div>

        <button ${botao} type="submit">Cadastrar</button>
    </form>
</div>
</body>
</html>
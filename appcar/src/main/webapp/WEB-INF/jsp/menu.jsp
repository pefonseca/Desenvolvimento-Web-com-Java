<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">AppCar</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <c:if test="${not empty usuario}">
                <li><a href="/usuario/lista">Usuario</a></li>
                <li><a href="/solicitante/lista">Solicitante</a></li>
                <li><a href="/veiculo/lista">Veiculo</a></li>
                <li><a href="/carro/lista">Carro</a></li>
                <li><a href="/moto/lista">Moto</a></li>
                <li><a href="/caminhao/lista">Caminhão</a></li>
                <li><a href="/pedido/lista">Pedido</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty usuario}">
                <li><a href="/usuario/lista"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${not empty usuario}">

                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${usuario.nome}</a></li>
            </c:if>
        </ul>
    </div>
</nav>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h2>Autenticação</h2>

        <c:if test="${not empty mensagem}">
            <div class="alert alert-danger">
                <strong>Atenção!</strong> ${mensagem}
            </div>
        </c:if>

        <form action="/login" method="post">
            <div class="form-group">
                <label>E-mail:</label>
                <input type="email" class="form-control" placeholder="Enter email" name="email" value="email@email.com">
            </div>
            <div class="form-group">
                <label>Senha:</label>
                <input type="password" class="form-control" placeholder="Enter password" name="senha" value="email@email.com">
            </div>
            <button type="submit" class="btn btn-secondary">Acessar</button>
        </form>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>Cadastro de Motos</title>
</head>
<body>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>

    <div class="container">
        <form action="/moto/incluir" method="post">
            <h3>Cadastro de Motos</h3>

            <div class="form-group">
                <label>Nome:</label>
                <input type="text" name="nome" value="1113" class="form-control">
            </div>

            <div class="form-group">
                <label>Cor:</label>
                <input type="text" name="cor" value="Azul" class="form-control">
            </div>

            <div class="form-group">
                <label>Ano:</label>
                <input type="text" name="ano" value="1980" class="form-control">
            </div>

            <div class="form-group">
                <label>Marca:</label>
                <input type="text" name="marca" value="Mercedes-Benz" class="form-control">
            </div>

            <div class="form-group">
                <label>Primeiro Dono:</label>
                <select name="primeiroDono" class="form-control">
                    <option value="Sim">Sim</option>
                    <option value="Nao">Nao</option>
                </select>
            </div>

            <div class="form-group">
                <label>Valor:</label>
                <input type="text" name="valor" value="125000" class="form-control">
            </div>

            <div class="form-group">
                <label>Quilometragem:</label>
                <input type="text" name="quilometragem" value="80000" class="form-control">
            </div>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>
</html>
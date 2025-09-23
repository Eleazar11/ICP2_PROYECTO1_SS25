<%-- 
    Document   : listarUsuarios
    Created on : 24/09/2025, 13:49:27
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Lista de Usuarios</h2>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Rol</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id_usuario}</td>
                    <td>${usuario.nombreCompleto}</td>
                    <td>${usuario.correoElectronico}</td>
                    <td>${usuario.telefono}</td>
                    <td>${usuario.tipoUsuario}</td>
                    <td>${usuario.estado}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/areaAdminSistema/vistaAdminSistema.jsp" class="btn btn-secondary">
            Volver a la página principal
        </a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

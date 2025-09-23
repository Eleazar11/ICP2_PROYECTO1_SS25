<%-- 
    Document   : registroUsuario
    Created on : 17/09/2025, 15:28:59
    Author     : eleaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Usuarios - Hyrule Events</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background: url('https://64.media.tumblr.com/cca4f06484b447c0687f0325af5b38c9/428a8db1dc8ae92f-87/s1280x1920/7c751558b1d93e15c2d885cff2162ddb95059b8d.gif') no-repeat center center fixed;
                background-size: cover;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <h2 class="text-center">Registro de Usuario</h2>
            <form method="POST" action="${pageContext.servletContext.contextPath}/RegistroServlet" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="nombreCompleto" class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto" required>
                </div>

                <div class="mb-3">
                    <label for="organizacion" class="form-label">Organización</label>
                    <select class="form-control" id="organizacion" name="organizacion" required>
                        <c:if test="${not empty instituciones}">
                            <c:forEach var="inst" items="${instituciones}">
                                <option value="${inst}">${inst}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty instituciones}">
                            <option value="">No hay instituciones disponibles por el momento</option>
                        </c:if>
                    </select>

                </div>


                <div class="mb-3">
                    <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                    <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" required>
                </div>

                <div class="mb-3">
                    <label for="contrasena" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="contrasena" name="contrasena" required minlength="6">
                </div>

                <div class="mb-3">
                    <label for="telefono" class="form-label">Número de Teléfono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono">
                </div>

                <div class="mb-3">
                    <label for="numeroIdentificacion" class="form-label">Número de Identificación</label>
                    <input type="text" class="form-control" id="numeroIdentificacion" name="numeroIdentificacion" required>
                </div>

                <div class="mb-3">
                    <label for="foto" class="form-label">Foto (opcional)</label>
                    <input type="file" class="form-control" id="foto" name="foto" accept="image/*">
                </div>

                <div class="text-center mb-3">
                    <button type="submit" class="btn btn-primary">Registrar</button>
                </div>

                <div class="text-center">
                    <a href="index.jsp" class="btn btn-secondary">Volver a la página principal</a>
                </div>
            </form>
        </div>
    </body>
</html>

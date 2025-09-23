<%-- 
    Document   : registroUsuarios.
    Created on : 23/09/2025, 12:46:58
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Registro de Usuario</h2>
    <div class="mx-auto col-md-6">
        <form method="POST" action="${pageContext.request.contextPath}/RegistroUsuariosServlet" enctype="multipart/form-data">
            <div class="mb-3">
                <label class="form-label">Nombre Completo</label>
                <input type="text" class="form-control" name="nombreCompleto" required>
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
                <label class="form-label">Correo Electrónico</label>
                <input type="email" class="form-control" name="correoElectronico" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input type="password" class="form-control" name="contrasena" required minlength="6">
            </div>

            <div class="mb-3">
                <label class="form-label">Teléfono</label>
                <input type="text" class="form-control" name="telefono">
            </div>

            <div class="mb-3">
                <label class="form-label">Número de Identificación</label>
                <input type="text" class="form-control" name="numeroIdentificacion" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Foto (opcional)</label>
                <input type="file" class="form-control" name="foto" accept="image/*">
            </div>

            <div class="mb-3">
                <label class="form-label">Rol</label>
                <select class="form-control" name="rol" required>
                    <option value="USUARIO">USUARIO</option>
                    <option value="PARTICIPANTE">PARTICIPANTE</option>
                    <option value="ADMIN_SISTEMA">ADMIN_SISTEMA</option>
                    <option value="ADMIN_CONGRESO">ADMIN_CONGRESO</option>
                </select>
            </div>

            <div class="text-center mb-3">
                <button type="submit" class="btn btn-primary">Registrar Usuario</button>
            </div>

            <div class="text-center">
                <a href="vistaAdminSistema.jsp" class="btn btn-secondary">Volver a la página principal</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>



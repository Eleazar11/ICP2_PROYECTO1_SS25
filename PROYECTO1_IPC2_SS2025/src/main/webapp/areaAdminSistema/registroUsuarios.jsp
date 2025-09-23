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
    <style>
        body {
            background: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/12cbe8a4-f55c-4b40-85bb-d8e1405e7b84/ddjib5a-1f4b4985-1401-437b-9b8f-b724d4dccca2.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiIvZi8xMmNiZThhNC1mNTVjLTRiNDAtODViYi1kOGUxNDA1ZTdiODQvZGRqaWI1YS0xZjRiNDk4NS0xNDAxLTQzN2ItOWI4Zi1iNzI0ZDRkY2NjYTIuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.eUDNcsCdf1ssB7fqjlSTV47xBUejPGBFzFev_vQUVRY') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
        }
        .main-container {
            display: flex;
            flex-direction: column;
            justify-content: flex-start; /* coloca el título arriba */
            align-items: center;
            min-height: 100vh;
            padding-top: 40px; /* espacio arriba */
        }
        .titulo-principal {
            font-size: 2rem;
            font-weight: bold;
            color: white;
            text-shadow: 3px 3px 6px black;
            margin-bottom: 30px;
            text-align: center;
        }
        .form-container {
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
            color: white;
            max-width: 500px;
            width: 100%;
        }
        .form-label {
            font-size: 1.1rem;
            font-weight: bold;
            color: white;
            text-shadow: 1px 1px 3px black;
        }
        .form-control {
            font-size: 1rem;
        }
    </style>
</head>
<body>
    <div class="main-container">
        <!-- Aquí está el título grande -->
        <div class="titulo-principal">Registro de Usuario</div>

        <!-- Aquí está el formulario -->
        <div class="form-container">
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
                        <option value="ADMIN_SISTEMA">ADMIN_SISTEMA</option>
                        <option value="ADMIN_CONGRESO">ADMIN_CONGRESO</option>
                    </select>
                </div>

                <div class="text-center mb-3">
                    <button type="submit" class="btn btn-primary">Registrar Usuario</button>
                </div>

                <div class="text-center">
                    <a href="${pageContext.request.contextPath}/areaAdminSistema/vistaAdminSistema.jsp" class="btn btn-secondary">Volver a la página principal</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>



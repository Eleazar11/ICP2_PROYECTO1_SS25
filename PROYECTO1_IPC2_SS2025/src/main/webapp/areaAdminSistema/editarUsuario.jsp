<%-- 
    Document   : editarUsuario
    Created on : 24/09/2025, 12:32:53
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Editar Usuarios</title>
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
        <div class="container mt-5">
            <h2 class="text-center mb-4">Lista de Usuarios</h2>
            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Teléfono</th>
                        <th>Rol</th>
                        <th>Estado</th>
                        <th>Acción</th>
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
                            <td>
                                <button class="btn btn-primary" 
                                        data-bs-toggle="modal" 
                                        data-bs-target="#editarModal${usuario.id_usuario}">
                                    Editar
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="editarModal${usuario.id_usuario}" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Editar Usuario</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                            </div>
                                            <form method="POST" action="${pageContext.request.contextPath}/EditarUsuariosServlet">
                                                <div class="modal-body">
                                                    <input type="hidden" name="idUsuario" value="${usuario.id_usuario}">
                                                    <div class="mb-3">
                                                        <label>Nombre Completo</label>
                                                        <input type="text" name="nombreCompleto" class="form-control" value="${usuario.nombreCompleto}" required>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Correo</label>
                                                        <input type="email" name="correoElectronico" class="form-control" value="${usuario.correoElectronico}" required>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Teléfono</label>
                                                        <input type="text" name="telefono" class="form-control" value="${usuario.telefono}">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Número Identificación</label>
                                                        <input type="text" name="numeroIdentificacion" class="form-control" value="${usuario.numeroIdentificacion}" required>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Rol</label>
                                                        <select name="rol" class="form-select">
                                                            <option value="USUARIO" ${usuario.tipoUsuario == 'USUARIO' ? 'selected' : ''}>USUARIO</option>
                                                            <option value="PARTICIPANTE" ${usuario.tipoUsuario == 'PARTICIPANTE' ? 'selected' : ''}>PARTICIPANTE</option>
                                                            <option value="ADMIN_SISTEMA" ${usuario.tipoUsuario == 'ADMIN_SISTEMA' ? 'selected' : ''}>ADMIN_SISTEMA</option>
                                                            <option value="ADMIN_CONGRESO" ${usuario.tipoUsuario == 'ADMIN_CONGRESO' ? 'selected' : ''}>ADMIN_CONGRESO</option>
                                                        </select>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Estado</label>
                                                        <select name="estado" class="form-select">
                                                            <option value="ACTIVO" ${usuario.estado == 'ACTIVO' ? 'selected' : ''}>ACTIVO</option>
                                                            <option value="INACTIVO" ${usuario.estado == 'INACTIVO' ? 'selected' : ''}>INACTIVO</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-success">Actualizar</button>
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="container mt-3">
                <a href="${pageContext.request.contextPath}/areaAdminSistema/vistaAdminSistema.jsp" class="btn btn-secondary">
                    Volver a Pantalla Principal
                </a>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>


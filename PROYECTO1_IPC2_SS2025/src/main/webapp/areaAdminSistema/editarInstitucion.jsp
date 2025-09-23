<%-- 
    Document   : editarInstitucion
    Created on : 23/09/2025, 11:24:18
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Editar Instituciones</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <style>
            body {
                background: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/12cbe8a4-f55c-4b40-85bb-d8e1405e7b84/ddjib5a-1f4b4985-1401-437b-9b8f-b724d4dccca2.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiIvZi8xMmNiZThhNC1mNTVjLTRiNDAtODViYi1kOGUxNDA1ZTdiODQvZGRqaWI1YS0xZjRiNDk4NS0xNDAxLTQzN2ItOWI4Zi1iNzI0ZDRkY2NjYTIuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.eUDNcsCdf1ssB7fqjlSTV47xBUejPGBFzFev_vQUVRY') no-repeat center center fixed;
                background-size: cover;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .form-container {
                background: rgba(255, 255, 255, 0.9);
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            }
            .form-label {
                font-size: 1.2rem;
                font-weight: bold;
                color: white;
                text-shadow: 2px 2px 4px black;
            }
            .form-control {
                font-size: 1.1rem;
            }
            .titulo-form {
                color: white;
                text-shadow: 3px 3px 6px black;
                font-size: 2rem;
                font-weight: bold;
            }
            .message-box {
                background: rgba(0, 0, 0, 0.6); /* Transparente oscuro */
                padding: 30px;
                border-radius: 12px;
                text-align: center;
                max-width: 400px;
                width: 100%;
                color: white;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
            }
            .message-box h1 {
                font-size: 1.8rem;
                margin-bottom: 15px;
            }
            .message-box p {
                font-size: 1.2rem;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Lista de Instituciones</h2>
            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="institucion" items="${instituciones}">
                        <tr>
                            <td>${institucion.idInstitucion}</td>
                            <td>${institucion.nombreInstitucion}</td>
                            <td>${institucion.direccion}</td>
                            <td>${institucion.telefono}</td>
                            <td>
                                <button class="btn btn-primary" 
                                        data-bs-toggle="modal" 
                                        data-bs-target="#editarModal${institucion.idInstitucion}">
                                    Editar
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="editarModal${institucion.idInstitucion}" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Editar Institución</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                            </div>
                                            <form method="POST" action="${pageContext.request.contextPath}/EditarInstitucionServlet">
                                                <div class="modal-body">
                                                    <input type="hidden" name="idInstitucion" value="${institucion.idInstitucion}">
                                                    <div class="mb-3">
                                                        <label>Nombre</label>
                                                        <input type="text" name="nombreInstitucion" class="form-control" value="${institucion.nombreInstitucion}" required>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Descripción</label>
                                                        <textarea name="descripcion" class="form-control">${institucion.desccripcion}</textarea>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Dirección</label>
                                                        <input type="text" name="direccion" class="form-control" value="${institucion.direccion}">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label>Teléfono</label>
                                                        <input type="text" name="telefono" class="form-control" value="${institucion.telefono}">
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
            <div class="text-center mt-4">
                <a href="${pageContext.request.contextPath}/areaAdminSistema/vistaAdminSistema.jsp" class="btn btn-secondary">Volver a la página principal</a>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>


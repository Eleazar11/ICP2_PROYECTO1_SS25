<%-- 
    Document   : crearInstitucion
    Created on : 22/09/2025, 11:48:00
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Instituciones</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/12cbe8a4-f55c-4b40-85bb-d8e1405e7b84/ddjib5a-1f4b4985-1401-437b-9b8f-b724d4dccca2.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiIvZi8xMmNiZThhNC1mNTVjLTRiNDAtODViYi1kOGUxNDA1ZTdiODQvZGRqaWI1YS0xZjRiNDk4NS0xNDAxLTQzN2ItOWI4Zi1iNzI0ZDRkY2NjYTIuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.eUDNcsCdf1ssB7fqjlSTV47xBUejPGBFzFev_vQUVRY') no-repeat center center fixed;
            background-size: cover;
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
    </style>
</head>
<body>
    <section class="container mt-5">
        <h2 class="text-center titulo-form">Registro de Institución</h2>
        <div class="form-container mx-auto col-md-6">
            <form method="POST" action="${pageContext.servletContext.contextPath}/RegistroInstitucionesServlet">
                <div class="mb-3">
                    <label for="nombreInstitucion" class="form-label">Nombre de la Institución</label>
                    <input type="text" class="form-control" id="nombreInstitucion" name="nombreInstitucion" required>
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
                </div>

                <div class="mb-3">
                    <label for="direccion" class="form-label">Dirección</label>
                    <input type="text" class="form-control" id="direccion" name="direccion">
                </div>

                <div class="mb-3">
                    <label for="telefono" class="form-label">Teléfono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono">
                </div>

                <div class="text-center mb-3">
                    <button type="submit" class="btn btn-primary">Registrar Institución</button>
                </div>
                <div class="text-center">
                    <a href="vistaAdminSistema.jsp" class="btn btn-secondary">Volver a la página principal</a>
                </div>
            </form>
        </div>
    </section>
</body>
</html>


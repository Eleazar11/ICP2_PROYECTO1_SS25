<%-- 
    Document   : confirmacion
    Created on : 22/09/2025, 17:40:42
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Acción Exitosa</title>
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
         <div class="message-box">
        <h1>Acción realizada con éxito</h1>
        <p>La operación se completó correctamente.</p>
        <a href="vistaAdminSistema.jsp" class="btn btn-success btn-custom">Volver al inicio</a>
    </div>
    </body>
</html>


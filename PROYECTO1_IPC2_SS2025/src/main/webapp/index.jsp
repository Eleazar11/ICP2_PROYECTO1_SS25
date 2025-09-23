<%-- 
    Document   : index
    Created on : 17/09/2025, 14:45:38
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            /* Asegurar que el body tenga altura completa */
            body {
                background: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/12cbe8a4-f55c-4b40-85bb-d8e1405e7b84/df1wdk7-fa62d5b6-a1b2-4b2b-b407-02e737476148.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiIvZi8xMmNiZThhNC1mNTVjLTRiNDAtODViYi1kOGUxNDA1ZTdiODQvZGYxd2RrNy1mYTYyZDViNi1hMWIyLTRiMmItYjQwNy0wMmU3Mzc0NzYxNDguZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.F-frglSp9cOGvRsq2UlP8J8vSQcB1bGuPNW8-uAZ_vM') no-repeat center center fixed;
                background-size: cover;
            }

            /* Estilo para el texto */
            body, p, h1, h2, h3, h4, h5, h6, span {

                color: white; /* Texto en blanco */
            }
        </style>

    </head>
    <body>
        <div class="container">
            <h2 class="text-center mt-5">Login HYRULE EVENTS</h2>

            <%
                String error = (String) request.getAttribute("error");
                if (error != null) {
            %>
            <div class="alert alert-danger" role="alert">
                <%= error%>
            </div>
            <%
                }
            %>

            <form action="LoginServlet" method="POST">
                <!-- Username input -->
                <div class="form-outline mb-4">
                    <input type="text" id="email" name="email" class="form-control" required>
                    <label class="form-label" for="loginUsername">Correo electronico</label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <input type="password" id="loginPassword" name="password" class="form-control" required>
                    <label class="form-label" for="loginPassword">Password</label>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">Iniciar Sesión</button>

                <!-- Register link -->
                <div class="text-center">
                    <p>No eres un usuario? 
                        <a href="${pageContext.servletContext.contextPath}/registroUsuario">Click para registrarte</a>
                    </p>

                </div>
            </form>
        </div>
    </body>
</html>
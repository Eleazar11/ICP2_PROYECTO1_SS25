<%-- 
    Document   : home
    Created on : 18/09/2025, 19:53:26
    Author     : eleaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    body {
        background: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/12cbe8a4-f55c-4b40-85bb-d8e1405e7b84/ddjib5a-1f4b4985-1401-437b-9b8f-b724d4dccca2.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiIvZi8xMmNiZThhNC1mNTVjLTRiNDAtODViYi1kOGUxNDA1ZTdiODQvZGRqaWI1YS0xZjRiNDk4NS0xNDAxLTQzN2ItOWI4Zi1iNzI0ZDRkY2NjYTIuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.eUDNcsCdf1ssB7fqjlSTV47xBUejPGBFzFev_vQUVRY') no-repeat center center fixed;
        background-size: cover;
    }

    /* Capa oscura para mejor contraste */
    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5); /* Oscurece un poco el fondo */
        z-index: -1;
    }

    /* Estilos adicionales */
    .content {
        position: relative;
        z-index: 1;
        color: white; /* Texto en blanco para contraste */
    }

    /* Espaciado para los botones */
    .button-container {
        margin-top: 20px;
    }
</style>

<div class="overlay"></div> <!-- Capa oscura para mejorar la visibilidad del contenido -->

<section class="mt-5 content">
    <h1 class="text-center">Bienvenido al módulo de administración</h1>
    <p class="text-center">Explora las funciones que puedes realizar al ser admin.</p>

    <div class="container d-flex justify-content-center">
        <div id="carouselExample" class="carousel slide w-75" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://redesla.la/wp-content/uploads/2024/02/congresos.jpg" 
                         class="d-block w-100 rounded-3" alt="Imagen 1">
                </div>
                <div class="carousel-item">
                    <img src="https://www.uaa.mx/portal/wp-content/uploads/2023/05/208-1-1024x683.jpg" 
                         class="d-block w-100 rounded-3" alt="Imagen 2">
                </div>
                <div class="carousel-item">
                    <img src="https://www.pucv.cl/uuaa/site/artic/20181106/imag/foto_0000000120181106164331.jpg" 
                         class="d-block w-100 rounded-3" alt="Imagen 3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Siguiente</span>
            </button>
        </div>
    </div>

    <!-- Contenedor de botones ../areaEnsamblaje/ensamblaje-->
    <!--
    <div class="container text-center button-container">
        <a href="../areaEnsamblaje/ensamblaje.jsp" class="btn btn-primary mx-2">Ir al Modulo de Ensamblaje</a>
        <a href="../areaVentas/ventas.jsp" class="btn btn-success mx-2">Ir al Modulo de Ventas</a>
    </div>
    -->
</section>

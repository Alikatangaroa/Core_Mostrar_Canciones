<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Detalle Artista</title>
</head>
<body>

    <h1>Detalle del Artista</h1>

    <p>
        <b>Nombre:</b> <c:out value="${artista.nombre}"/> <c:out value="${artista.apellido}"/>
    </p>
    <p>
        <b>Biografía:</b> <c:out value="${artista.biografia}"/>
    </p>
    <p>
        <b>Creado:</b> <c:out value="${artista.fechaCreacion}"/>
    </p>
    <p>
        <b>Actualizado:</b> <c:out value="${artista.fechaActualizacion}"/>
    </p>

    <h2>Canciones</h2>

    <ul>
    <c:forEach var="cancion" items="${artista.canciones}">
        <li>
        <a href="/canciones/detalle/${cancion.id}">
            <c:out value="${cancion.titulo}"/>
        </a>
        </li>
    </c:forEach>
    </ul>

    <br>
    <a href="/artistas">Volver a lista de artistas</a>

</body>
</html>
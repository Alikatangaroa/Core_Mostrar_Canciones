<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Artistas</title>
</head>
<body>

    <h1>Lista de Artistas</h1>

    <ul>
    <c:forEach var="a" items="${listaArtistas}">
        <li>
        <a href="/artistas/detalle/${a.id}">
            <c:out value="${a.nombre}"/> <c:out value="${a.apellido}"/>
        </a>
        </li>
    </c:forEach>
    </ul>

    <br>
    <a href="/artistas/formulario/agregar">Agregar artista</a>

    <br><br>
    <a href="/canciones">Ir a canciones</a>

</body>
</html>
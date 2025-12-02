<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
</head>
<body>

<h1>Lista de Canciones</h1>

<table border="1" cellpadding="8">
    <tr>
        <th>Título</th>
        <th>Artista</th>
        <th>Detalle</th>
    </tr>

    <c:forEach var="cancion" items="${listaCanciones}">
        <tr>
            <td>${cancion.titulo}</td>
            <td>
                <a href="/artistas/detalle/${cancion.artista.id}">
                    <c:out value="${cancion.artista.nombre}"/> <c:out value="${cancion.artista.apellido}"/>
                </a>
            </td>
            <td><a href="/canciones/detalle/${cancion.id}">Ver detalle</a></td>
            
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="/canciones/formulario/agregar">
    <button type="button">Agregar canción</button>
</a>
<br><br>
<a href="/artistas">Ir a artistas</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de Canción</title>
</head>
<body>

    <h1>Detalle de la Canción</h1>

    <c:choose>
        <c:when test="${cancion != null}">
            <table border="1" cellpadding="8">
                <tr>
                    <th>ID</th>
                    <td>${cancion.id}</td>
                </tr>

                <tr>
                    <th>Título</th>
                    <td>${cancion.titulo}</td>
                </tr>

                <tr>
                    <th>Artista</th>
                    <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
                </tr>

                <tr>
                    <th>Álbum</th>
                    <td>${cancion.album}</td>
                </tr>

                <tr>
                    <th>Género</th>
                    <td>${cancion.genero}</td>
                </tr>

                <tr>
                    <th>Idioma</th>
                    <td>${cancion.idioma}</td>
                </tr>

                <tr>
                    <th>Creado en</th>
                    <td>
                        <c:out value="${cancion.fechaCreacion}" default="(null)"/>
                    
                    </td>
                </tr>

                <tr>
                    <th>Actualizado en</th>
                    <td>
                    <c:out value="${cancion.fechaActualizacion}" default="(null)"/>
                        
                    </td>
                </tr>
            </table>
            <br>
            <a href="/canciones/formulario/editar/${cancion.id}">Actualizar canción</a>
            <br><br>
            <form action="/canciones/eliminar/${cancion.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button type="submit">Eliminar canción</button>
            </form>
        </c:when>

        <c:otherwise>
            <p>La canción no se encuentra en la base de datos.</p>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="/canciones">Volver a la lista de canciones</a>

</body>
</html>
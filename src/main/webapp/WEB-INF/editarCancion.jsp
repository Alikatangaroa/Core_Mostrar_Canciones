<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Canción</title>
</head>
<body>

    <h1>Editar Canción</h1>
    <form:form method="POST"
        action="/canciones/procesa/editar/${cancion.id}"
        modelAttribute="cancion">

        <input type="hidden" name="_method" value="put"/>
        <form:hidden path="id"/>

        <p>
            <form:label path="titulo">Título:</form:label><br/>
            <form:input path="titulo"/>
            <form:errors path="titulo"/>
        </p>

        <p>
            <label>Artista:</label><br/>
                <select name="idArtista">
                    <c:forEach var="a" items="${listaArtistas}">
                    <option value="${a.id}" ${a.id == cancion.artista.id ? "selected" : ""}>
                        ${a.nombre} ${a.apellido}
                    </option>
                    </c:forEach>
                </select>
            <form:errors path="artista"/>
        </p>

        <p>
            <form:label path="album">Álbum:</form:label><br/>
            <form:input path="album"/>
            <form:errors path="album"/>
        </p>

        <p>
            <form:label path="genero">Género:</form:label><br/>
            <form:input path="genero"/>
            <form:errors path="genero"/>
        </p>

        <p>
            <form:label path="idioma">Idioma:</form:label><br/>
            <form:input path="idioma"/>
            <form:errors path="idioma"/>
        </p>

        <button type="submit">Actualizar</button>
    </form:form>

<br>
<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Agregar Canción</title>
</head>
<body>

<h1>Agregar Canción</h1>

<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">

  <div>
    <form:label path="titulo">Título:</form:label>
    <form:input path="titulo"/>
    <form:errors path="titulo"/>
  </div>

  <div>
    <label>Artista:</label><br/>
      <select name="idArtista" required>
        <option value="">-- Selecciona un artista --</option>
        <c:forEach var="a" items="${listaArtistas}">
          <option value="${a.id}">${a.nombre} ${a.apellido}</option>
        </c:forEach>
      </select>
    <form:errors path="artista"/>
  </div>

  <div>
    <form:label path="album">Álbum:</form:label>
    <form:input path="album"/>
    <form:errors path="album"/>
  </div>

  <div>
    <form:label path="genero">Género:</form:label>
    <form:input path="genero"/>
    <form:errors path="genero"/>
  </div>

  <div>
    <form:label path="idioma">Idioma:</form:label>
    <form:input path="idioma"/>
    <form:errors path="idioma"/>
  </div>

  <button type="submit">Guardar</button>
</form:form>

<hr/>
<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>
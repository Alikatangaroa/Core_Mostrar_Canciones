<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Agregar Artista</title>
</head>
<body>

    <h1>Agregar Artista</h1>

    <form:form method="POST" action="/artistas/procesa/agregar" modelAttribute="artista">

    <div>
        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre"/>
        <form:errors path="nombre"/>
    </div>

    <div>
        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido"/>
        <form:errors path="apellido"/>
    </div>

    <div>
        <form:label path="biografia">Biografía:</form:label><br/>
        <form:textarea path="biografia" rows="5" cols="40"/>
        <form:errors path="biografia"/>
    </div>

    <button type="submit">Guardar</button>
    </form:form>

    <br>
    <a href="/artistas">Volver a lista de artistas</a>

</body>
</html>
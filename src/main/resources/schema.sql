CREATE DATABASE IF NOT EXISTS canciones_db;
USE canciones_db;

CREATE TABLE IF NOT EXISTS canciones (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255),
  artista VARCHAR(255),
  album VARCHAR(255),
  genero VARCHAR(255),
  idioma VARCHAR(255),
  fecha_creacion DATE,
  fecha_actualizacion DATE
);
package com.omar.apiuniversidad.servicios.contratos;

import com.omar.apiuniversidad.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}

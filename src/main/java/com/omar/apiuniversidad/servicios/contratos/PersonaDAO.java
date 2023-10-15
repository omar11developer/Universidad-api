package com.omar.apiuniversidad.servicios.contratos;

import com.omar.apiuniversidad.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDNI(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String appellido);
}

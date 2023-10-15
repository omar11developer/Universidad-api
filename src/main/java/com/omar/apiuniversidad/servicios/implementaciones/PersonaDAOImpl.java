package com.omar.apiuniversidad.servicios.implementaciones;

import com.omar.apiuniversidad.modelo.entidades.Persona;
import com.omar.apiuniversidad.repositorios.PersonaRepository;
import com.omar.apiuniversidad.servicios.contratos.GenericoDAO;
import com.omar.apiuniversidad.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona,PersonaRepository> implements PersonaDAO {
    public PersonaDAOImpl(PersonaRepository repository){
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDNI(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String appellido) {
        return repository.buscarPersonaPorApellido(appellido);
    }
}

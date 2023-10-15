package com.omar.apiuniversidad.servicios.implementaciones;

import com.omar.apiuniversidad.modelo.entidades.Persona;
import com.omar.apiuniversidad.repositorios.AlumnoRepository;
import com.omar.apiuniversidad.repositorios.PersonaRepository;
import com.omar.apiuniversidad.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository){
        super(repository);
    }

    @Override
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}

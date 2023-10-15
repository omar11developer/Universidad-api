package com.omar.apiuniversidad.controlador;

import com.omar.apiuniversidad.modelo.entidades.Alumno;
import com.omar.apiuniversidad.modelo.entidades.Carrera;
import com.omar.apiuniversidad.modelo.entidades.Persona;
import com.omar.apiuniversidad.servicios.contratos.AlumnoDAO;
import com.omar.apiuniversidad.servicios.contratos.CarreraDAO;
import com.omar.apiuniversidad.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController extends PersonaController{
    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }


    @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Persona alumnoUpdate =null;
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()){
            throw new RuntimeException(String.format("Alumno con id %d no existe",id));

        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()){
            throw new RuntimeException(String.format("Alumno con id %d no existe"));
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new RuntimeException(String.format("Carrera con id %d no existe", idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);
        return service.save(alumno);
    }



}

package com.omar.apiuniversidad.controlador;

import com.omar.apiuniversidad.exception.BadRequestExecption;
import com.omar.apiuniversidad.modelo.entidades.Persona;
import com.omar.apiuniversidad.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericoController<Persona, PersonaDAO>{
    public PersonaController(PersonaDAO service){super(service);}

    @GetMapping("/nombre-apellido")
    public Persona busPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()){
            throw new BadRequestExecption(String.format("No se encontraron Personas con nombre %s y apellido %s", nombre, apellido));

        }
        return oPersona.get();
    }


}

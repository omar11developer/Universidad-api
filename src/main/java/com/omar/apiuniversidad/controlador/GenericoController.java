package com.omar.apiuniversidad.controlador;

import com.omar.apiuniversidad.exception.BadRequestExecption;
import com.omar.apiuniversidad.servicios.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericoController <E, S extends GenericoDAO<E>>{
    protected final S service;
    protected String nombreEntidad;

    public GenericoController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty()){
            throw new BadRequestExecption(String.format("No se han encontrado %ss", nombreEntidad));
        }
        return listado;
    }



}

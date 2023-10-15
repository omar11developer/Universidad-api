package com.omar.apiuniversidad.controlador;

import com.omar.apiuniversidad.exception.BadRequestExecption;
import com.omar.apiuniversidad.modelo.entidades.Carrera;
import com.omar.apiuniversidad.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController extends GenericoController<Carrera, CarreraDAO> {
    @Autowired
    public CarreraController(CarreraDAO service){
        super(service);
        nombreEntidad="Carrera";
    }
    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestExecption(String.format("La carrera con id %d no existe", id));
        }
        return oCarrera.get();
    }
    @PostMapping
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if(carrera.getCantidadAnios() < 0){
            throw new RuntimeException("El campo cantidad de años no puede ser negativo");

        }
        if (carrera.getCantidaMaterial()<0){
            throw new BadRequestExecption("El campo de materias no puede ser negativo");
        }
        return service.save(carrera);
    }
    @PutMapping("{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestExecption(String.format("La carrera con id %d no existe",id));

        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidaMaterial(carrera.getCantidaMaterial());
        return service.save(carreraUpdate);

    }
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }
}

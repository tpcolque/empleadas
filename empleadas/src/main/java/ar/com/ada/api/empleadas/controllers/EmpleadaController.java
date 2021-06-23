package ar.com.ada.api.empleadas.controllers;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.empleadas.entities.Empleada;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.servicies.EmpleadaService;

@RestController

public class EmpleadaController {

    private EmpleadaService service;

    @GetMapping("/empleados")
    public ResponseEntity <List<Empleada>> traerEmpleadas(){
        List<Empleada> lista = service.traerEmpleadas();
        return ResponseEntity.ok(lista);

    }
    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleada(@RequestBody Empleada empleada){
        GenericResponse respuesta = new GenericResponse();
        service.crearEmpleada(empleada);
        respuesta.isOk = true;
        respuesta.id = empleada.getEmpleadaId();
        respuesta.message = "La empleada fue creada con exito";
        return ResponseEntity.ok(respuesta);


    }
}

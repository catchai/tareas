package com.tareas.tareas.controller;

import com.tareas.tareas.model.Tarea;
import com.tareas.tareas.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author asandoval
 */
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @Operation(summary = "Obtiene todos los tareas")
    @GetMapping
    public ResponseEntity<List<Tarea>> findAll() {
        return ResponseEntity.ok(tareaService.findAll());
    }

    @Operation(summary = "Obtiene un tarea por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> findById(
            @Parameter(description = "Identificador del tarea que desea obtener")
            @PathVariable("id") Integer idTarea) {
        return tareaService.findById(idTarea)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Realiza la creación de un tarea")
    @PostMapping
    public ResponseEntity<Tarea> create(@Valid @RequestBody Tarea tarea) {
        return new ResponseEntity<>(tareaService.create(tarea), HttpStatus.CREATED);
    }

    @Operation(summary = "Modifica un tarea")
    @PutMapping
    public ResponseEntity<Tarea> update(@Valid @RequestBody Tarea tarea) {
        return tareaService.findById(tarea.getIdTarea())
                .map(c -> ResponseEntity.ok(tareaService.update(tarea)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Elimina un tarea")
    @DeleteMapping("/{id}")
    public ResponseEntity<Tarea> delete(
            @Parameter(description = "Identificador del tarea que desea eliminar")
            @PathVariable("id") Integer idTarea) {
        return tareaService.findById(idTarea)
                .map(c -> {
                    tareaService.delete(idTarea);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

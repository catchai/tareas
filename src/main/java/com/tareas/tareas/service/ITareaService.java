package com.tareas.tareas.service;

import com.tareas.tareas.model.Tarea;

import java.util.List;
import java.util.Optional;

/**
 * @author asandoval
 */
public interface ITareaService {

    List<Tarea> findAll();

    Optional<Tarea> findById(Integer id);

    Tarea create(Tarea tarea);

    Tarea update(Tarea tarea);

    void delete(Integer id);
}

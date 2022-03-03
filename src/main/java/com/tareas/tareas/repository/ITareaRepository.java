package com.tareas.tareas.repository;

import com.tareas.tareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author asandoval
 */
public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
}

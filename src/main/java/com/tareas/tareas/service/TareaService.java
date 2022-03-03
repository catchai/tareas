package com.tareas.tareas.service;

import com.tareas.tareas.model.Tarea;
import com.tareas.tareas.repository.ITareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author asandoval
 */
@Service
public class TareaService implements ITareaService {

    @Autowired
    private ITareaRepository tareaRepo;

    @Override
    public List<Tarea> findAll() {
        return tareaRepo.findAll();
    }

    @Override
    public Optional<Tarea> findById(Integer id) {
        return tareaRepo.findById(id);
    }

    @Override
    public Tarea create(Tarea tarea) {
        return tareaRepo.save(tarea);
    }

    @Override
    public Tarea update(Tarea tarea) {
        return tareaRepo.save(tarea);
    }

    @Override
    public void delete(Integer id) {
        tareaRepo.deleteById(id);
    }
}

package com.tareas.tareas.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author asandoval
 */
@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 70, message = "El nombre debe ser menor a 3 caracteres o max 70")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;
 
    @Size(max = 15, message = "El titulo no debe superar los 15 caracteres")
    @Column(name = "titulo", nullable = false, length = 15)
    private String titulo;

    @Size(min = 8, message = "La descripcion debe tener al menos 150 caracteres")
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @NotNull
    @NotBlank(message = "El email es obligatorio")
    @Size(min = 10, message = "EL email debe ser al menos de 10 caracteres")
    @Email(message = "El email enviado no es un formato válido")
    @Column(nullable = false, length = 40)
    private String email;

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

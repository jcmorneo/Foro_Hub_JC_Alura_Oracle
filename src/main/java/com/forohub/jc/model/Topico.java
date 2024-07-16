package com.forohub.jc.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public void setTitulo(String titulo) {
    }

    public void setMensaje(String mensaje) {
    }

    public void setAutorId(Long autorId) {
    }

    public void setCursoId(Long cursoId) {
    }

    public void setFechaCreacion(LocalDateTime now) {
    }

    public void setEstado(String activo) {
    }

    // Getters y setters
}

package com.forohub.jc.service;

import com.forohub.jc.dto.TopicoRequest;
import com.forohub.jc.dto.TopicoResponse;
import com.forohub.jc.model.Topico;
import com.forohub.jc.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Page<TopicoResponse> listarConPaginacion(Pageable pageable) {
        return topicoRepository.findAll(pageable).map(this::convertirADto);
    }

    public TopicoResponse obtenerPorId(Long id) throws ResourceNotFoundException {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            return convertirADto(topico);
        } else {
            throw new ResourceNotFoundException("Tópico no encontrado con ID: " + id);
        }
    }

    public TopicoResponse crearTopico(TopicoRequest topicoRequest) {
        Topico topico = new Topico();
        topico.setTitulo(topicoRequest.getTitulo());
        topico.setMensaje(topicoRequest.getMensaje());
        topico.setAutorId(topicoRequest.getAutorId());
        topico.setCursoId(topicoRequest.getCursoId());
        topico.setFechaCreacion(LocalDateTime.now());
        topico.setEstado("activo"); // Puedes cambiar este valor según tu lógica
        topicoRepository.save(topico);
        return convertirADto(topico);
    }

    public void eliminarTopico(Long id) throws ResourceNotFoundException {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.delete(optionalTopico.get());
        } else {
            throw new ResourceNotFoundException("Tópico no encontrado con ID: " + id);
        }
    }

    private TopicoResponse convertirADto(Topico topico) {
        // Implementación omitida para brevedad
        return null;
    }

    public List<TopicoResponse> listarTodos() {
        return List.of();
    }

    public TopicoResponse actualizarTopico(Long id, TopicoRequest topicoRequest) {
        return null;
    }

    // Métodos obtenerNombreAutor y obtenerNombreCurso omitidos para brevedad
}

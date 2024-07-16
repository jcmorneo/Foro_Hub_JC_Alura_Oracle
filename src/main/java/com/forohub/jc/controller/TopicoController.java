package com.forohub.jc.controller;

import com.forohub.jc.dto.TopicoRequest;
import com.forohub.jc.dto.TopicoResponse;
import com.forohub.jc.service.ResourceNotFoundException;
import com.forohub.jc.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<TopicoResponse> listarTodos() {
        return topicoService.listarTodos();
    }

    @GetMapping("/paginado")
    @PreAuthorize("hasRole('USER')")
    public Page<TopicoResponse> listarConPaginacion(
            @PageableDefault(sort = "fechaCreacion", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        return topicoService.listarConPaginacion(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public TopicoResponse obtenerPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return topicoService.obtenerPorId(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TopicoResponse crearTopico(@Valid @RequestBody TopicoRequest topicoRequest) {
        return topicoService.crearTopico(topicoRequest);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TopicoResponse> actualizarTopico(
            @PathVariable Long id,
            @Valid @RequestBody TopicoRequest topicoRequest) throws ResourceNotFoundException {
        TopicoResponse updatedTopico = topicoService.actualizarTopico(id, topicoRequest);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) throws ResourceNotFoundException {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username")
    public ResponseEntity<String> obtenerNombreUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(username);
    }

    // Otros métodos y manejo de excepciones según las necesidades
}



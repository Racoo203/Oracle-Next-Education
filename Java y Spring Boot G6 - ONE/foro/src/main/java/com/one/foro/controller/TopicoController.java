package com.one.foro.controller;

import com.one.foro.model.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // POST

    @PostMapping
    public ResponseEntity<GetTopico> registrarTopico(@RequestBody @Valid PostTopico postTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(postTopico));
        GetTopico getTopico = new GetTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(getTopico);

    }

    // GET

    @GetMapping("/{id}")
    public ResponseEntity<GetTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new GetTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
        return ResponseEntity.ok(datosTopico);
    }

    @GetMapping
    public ResponseEntity<Page<GetTopico>> listadoTopico(@PageableDefault(size = 3) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(GetTopico::new));
    }

    // PUT

    @PutMapping
    @Transactional
    public ResponseEntity<GetTopico> actualizarTopico(@RequestBody @Valid PutTopico putTopico) {
        Topico topico = topicoRepository.getReferenceById(putTopico.Id());
        topico.actualizarTopico(putTopico);
        return ResponseEntity.ok(new GetTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

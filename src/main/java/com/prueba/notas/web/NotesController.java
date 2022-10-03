package com.prueba.notas.web;

import com.prueba.notas.entity.Notes;
import com.prueba.notas.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Transactional
@RequestMapping("/api/notes")
@RestController
public class NotesController {
    private final NotesService service;

    public NotesController(NotesService service) {
        this.service = service;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<List<Notes>> getAllNotes() {
        log.info("Devolver Lista");
        return service.getAllNotes();
    }

    @GetMapping(value = "/notes-by-student/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Notes> getNotesByStudent(@PathVariable("code") Long code) {
        log.info("Devolver Notes del Alumno {}", code);
        return service.getNotesByStudent(code);
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void calcular(@RequestBody Notes request) {
        log.info("Add new Notes");
        service.addNotesByStudent(request).subscribe();
    }
}

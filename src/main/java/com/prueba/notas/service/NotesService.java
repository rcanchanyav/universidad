package com.prueba.notas.service;

import com.prueba.notas.entity.Notes;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NotesService {

    Flux<List<Notes>> getAllNotes();

    Mono<Notes> getNotesByStudent(Long code);

    Mono<Notes> addNotesByStudent(Notes notes);
}

package com.prueba.notas.service;

import com.prueba.notas.entity.Notes;
import com.prueba.notas.exception.MyException;
import com.prueba.notas.repository.NotesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class NotesServiceImpl implements NotesService {

    private final NotesRepository repository;

    public NotesServiceImpl(NotesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<List<Notes>> getAllNotes() {
        return Flux.just(repository.findAll());
    }

    @Override
    public Mono<Notes> getNotesByStudent(Long code) {
        return Mono.just(repository.findByCodeStudent(code)).map(rs -> {
            try {
                if (rs.isPresent()) {
                    return rs.get();
                }
                throw new MyException("No se ha registrado dicho codigo de Alumno");
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Mono<Notes> addNotesByStudent(Notes notes) {
        //se debe crear el servicio que valide que el alumno existe
        return Mono.create(sbs -> repository.save(notes));
    }
}

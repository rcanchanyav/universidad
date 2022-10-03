package com.prueba.notas.repository;

import com.prueba.notas.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    Optional<Notes> findByCodeStudent(Long codeStudent);

    List<Notes> findAll();

}

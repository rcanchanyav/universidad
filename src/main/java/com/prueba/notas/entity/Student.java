package com.prueba.notas.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Table(name = "alumno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String email;
    @OneToMany
    private List<Notes> notes;
}

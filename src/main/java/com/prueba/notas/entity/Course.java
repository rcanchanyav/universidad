package com.prueba.notas.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;
    private String name;
}

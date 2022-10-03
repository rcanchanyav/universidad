package com.prueba.notas.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Entity
@Table(name = "notas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;
    private Long codeStudent;
    private Long codeCourse;
    private Double average;
}

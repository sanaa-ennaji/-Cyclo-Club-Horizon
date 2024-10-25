package org.sanaa.brif6.CCH.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @NotBlank
    @Column(unique = true , nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate ;

    @Column(nullable = false)
    private LocalDate endDate ;


    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Stage> stages;


}

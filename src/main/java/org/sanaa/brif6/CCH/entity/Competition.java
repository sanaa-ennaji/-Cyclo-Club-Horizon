package org.sanaa.brif6.CCH.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @NotBlank
    @Column(unique = true , nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate  startDate ;

    @Column(nullable = false)
    private LocalDate endDate ;


   @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Stage> stages;




}

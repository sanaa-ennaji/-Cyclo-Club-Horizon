package org.sanaa.brif6.CCH.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name ="competetion")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @NotBlank
    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private LocalDate  startDate ;

    @Column(nullable = false)
    private LocalDate endDate ;







}

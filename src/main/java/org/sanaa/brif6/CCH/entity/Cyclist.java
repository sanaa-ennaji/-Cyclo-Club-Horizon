package org.sanaa.brif6.CCH.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cyclist")
public  class Cyclist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String nationality ;

    @Column(nullable = false)
    private int age ;

    @ManyToOne
    @JoinColumn(name ="team_id" , nullable = false)
    private Team team ;




}

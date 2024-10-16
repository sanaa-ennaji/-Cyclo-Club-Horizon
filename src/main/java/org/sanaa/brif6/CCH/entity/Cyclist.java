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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "LastName")
    private String  LastName ;

    @Column(name = "nationality")
    private String Nationality ;

    @Column (name = "age")
    private String  Age ;










}

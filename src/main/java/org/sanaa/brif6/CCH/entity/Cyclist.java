package org.sanaa.brif6.CCH.entity;

import com.sun.istack.NotNull;
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
    private String  LastName ;

    @Column(nullable = false)
    private String Nationality ;

    @Column(nullable = false)
    private String  Age ;




}

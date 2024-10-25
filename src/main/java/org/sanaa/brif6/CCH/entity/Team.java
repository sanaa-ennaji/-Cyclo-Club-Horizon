package org.sanaa.brif6.CCH.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String teamName ;
    @NotBlank
    @Column(nullable = false)
    private String nationality ;
    @OneToMany(mappedBy = "competition" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cyclist> cyclists ;



}
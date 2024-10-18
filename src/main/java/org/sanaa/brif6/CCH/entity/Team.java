package org.sanaa.brif6.CCH.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

    @NotBlank
    private String teamName ;


}

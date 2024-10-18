package org.sanaa.brif6.CCH.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Duration;
@Getter
@Setter
@Table(name = "result")
public class Result {

    @MapsId("cyclist")
    @ManyToOne
    @JoinColumn(name = "cyclist_id" , insertable = false , updatable = false)
    private Cyclist cyclist;

    @MapsId("stage")
    @ManyToOne
    @JoinColumn(name = "stage_id" , insertable = false , updatable = false)
    private Stage stage ;

    @EmbeddedId
    private  EmbeddedresultId  id;

    @Column(nullable = false)
    private Duration time;

    @NotBlank
    @Column(nullable = false)
    private String rank ;
}



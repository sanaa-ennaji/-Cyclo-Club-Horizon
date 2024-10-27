package org.sanaa.brif6.CCH.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedResult;

import java.time.Duration;
@Entity
@Getter
@Setter
@Table(name = "result")
public class Result {

    @MapsId("cyclist")
    @ManyToOne
    @JoinColumn(name = "cyclist_id", insertable = false, updatable = false)
    private Cyclist cyclist;

    @MapsId("stage")
    @ManyToOne
    @JoinColumn(name = "stage_id", insertable = false, updatable = false)
    private Stage stage;

    @EmbeddedId
    private EmbeddedResult id;

    @Column(nullable = false)
    private Duration time;

    @NotBlank
    @Column(nullable = false)
    private String rank;

}
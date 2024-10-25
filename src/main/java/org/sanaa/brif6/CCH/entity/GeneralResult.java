package org.sanaa.brif6.CCH.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedGeneralResult;

import java.time.Duration;

@Entity
@Table(name = "general_result")
@Getter
@Setter
public class GeneralResult{
    @EmbeddedId
    private EmbeddedGeneralResult id ;

    @MapsId("cyclist")
    @ManyToOne
    @JoinColumn(name = "cyclist_id", insertable = false, updatable = false)
    private Cyclist cyclist;

    @MapsId("competition")
    @ManyToOne
    @JoinColumn(name = "competition_id", insertable = false, updatable = false)
    private Competition competition;

    @Column(nullable = false)
    private String generalRank;

    @Column(nullable = false)
    private Duration time;



}

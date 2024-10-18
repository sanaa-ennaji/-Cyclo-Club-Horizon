package org.sanaa.brif6.CCH.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "general_result")
@Getter
@Setter
public class GenarlResult {
    @EmbeddedId
    private EmbeddedGeneralRId id ;

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

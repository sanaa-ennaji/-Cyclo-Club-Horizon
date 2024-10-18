package org.sanaa.brif6.CCH.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EmbeddedGeneralRId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "cyclist_id", nullable = false)
    private Cyclist cyclist;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;


}

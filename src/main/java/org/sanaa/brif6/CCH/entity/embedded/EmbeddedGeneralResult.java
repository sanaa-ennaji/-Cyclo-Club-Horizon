package org.sanaa.brif6.CCH.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.entity.Cyclist;

import java.io.Serializable;

@Embeddable
public class EmbeddedGeneralResult implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cyclist_id", nullable = false)
    private Cyclist cyclist;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;


}

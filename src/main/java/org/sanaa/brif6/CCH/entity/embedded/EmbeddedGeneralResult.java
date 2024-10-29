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

    public EmbeddedGeneralResult() {}


    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

}

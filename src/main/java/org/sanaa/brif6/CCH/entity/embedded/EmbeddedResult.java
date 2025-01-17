package org.sanaa.brif6.CCH.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.entity.Stage;

import java.io.Serializable;

@Embeddable
public class EmbeddedResult  implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cyclist_id" , nullable = false)
    private Cyclist cyclist;

    @ManyToOne
    @JoinColumn(name = "stage_id" ,nullable = false)
    private Stage stage;



    public Long getCyclistId() {
        return cyclist != null ? cyclist.getId() : null;
    }

    public Long getStageId() {
        return stage != null ? stage.getId() : null;
    }


    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

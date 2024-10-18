package org.sanaa.brif6.CCH.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EmbeddedresultId {

    @ManyToOne
    @JoinColumn(name = "cyclist_id" , nullable = false)
    private Cyclist cyclist;

    @ManyToOne
    @JoinColumn(name = "stage_id" ,nullable = false)
    private Stage stage;



}

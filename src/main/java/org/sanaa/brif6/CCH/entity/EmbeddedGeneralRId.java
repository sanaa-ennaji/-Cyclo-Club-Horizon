package org.sanaa.brif6.CCH.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EmbeddedRId implements Serializable {

    @ManyToOne
    private Cyclist cyclist ;

    @ManyToOne
    private Competition competition;





}

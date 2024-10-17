package org.sanaa.brif6.CCH.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Duration;

@Entity
@Table(name = "general_result")
@Getter
@Setter
public class GenarlResult {
    @EmbeddedId
    private EmbeddedRId id ;

    @NotNull
    private String rank ;

    private Duration time ;




}

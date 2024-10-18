package org.sanaa.brif6.CCH.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CompetitionDTO {

    private Long id ;
    private String name ;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<StageDTO> stages;
    // class umiable


}

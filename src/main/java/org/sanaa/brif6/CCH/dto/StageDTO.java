package org.sanaa.brif6.CCH.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class StageDTO {

    private Long id ;
    private String stageName;
    private double number;
    private String startPoint;
    private String endPoint ;
    private LocalDate startDate;
    private Long competitionId;


}

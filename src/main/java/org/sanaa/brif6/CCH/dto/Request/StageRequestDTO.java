package org.sanaa.brif6.CCH.dto.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StageRequestDTO {
    private String stageName;
    private double number;
    private String startPoint;
    private String endPoint;
    private LocalDate startDate;

}

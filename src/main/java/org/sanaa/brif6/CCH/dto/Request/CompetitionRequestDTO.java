package org.sanaa.brif6.CCH.dto.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CompetitionRequestDTO {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

}

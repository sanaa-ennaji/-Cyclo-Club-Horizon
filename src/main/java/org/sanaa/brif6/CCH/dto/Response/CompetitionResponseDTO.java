package org.sanaa.brif6.CCH.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompetitionResponseDTO {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}

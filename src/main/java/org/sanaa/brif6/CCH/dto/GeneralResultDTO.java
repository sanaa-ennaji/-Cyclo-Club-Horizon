package org.sanaa.brif6.CCH.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class GeneralResultDTO {
    private Long cyclistId;
    private Long competitionId;
    private String generalRank;
    private Duration time;
}

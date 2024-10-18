package org.sanaa.brif6.CCH.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class ResultDTO {
    private Long cyclistId;
    private Long stageId;
    private Duration time;
    private String rank;
}

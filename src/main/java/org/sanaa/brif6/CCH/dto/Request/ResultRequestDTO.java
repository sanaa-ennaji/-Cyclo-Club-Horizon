package org.sanaa.brif6.CCH.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultRequestDTO {
    private Long cyclistId;
    private Long stageId;
    private String rank;
    private String time;
}
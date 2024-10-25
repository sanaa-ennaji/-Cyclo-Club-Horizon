package org.sanaa.brif6.CCH.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResultRequestDTO {

    private Long cyclistId;
    private Long competitionId;
    private String generalRank;
    private String time;
}

package org.sanaa.brif6.CCH.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResultResponseDTO {

    private Long cyclistId;
    private Long competitionId;
    private String generalRank;
    private String time;
}


package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;

public interface CompetitionServiceI {
    CompetitionResponseDTO create (CompetitionRequestDTO requestDTO);
}

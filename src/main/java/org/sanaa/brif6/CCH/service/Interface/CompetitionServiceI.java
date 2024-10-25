package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;

import java.util.List;

public interface CompetitionServiceI {
    CompetitionResponseDTO create (CompetitionRequestDTO requestDTO);

    CompetitionResponseDTO getCompetitionById(Long id);

    List<CompetitionResponseDTO> getAllCompetitions();

    CompetitionResponseDTO updateCompetition(Long id, CompetitionRequestDTO requestDTO);

    void deleteCompetition(Long id);
}

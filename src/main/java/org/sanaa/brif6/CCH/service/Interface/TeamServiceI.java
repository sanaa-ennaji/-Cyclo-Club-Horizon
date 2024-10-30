package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.TeamRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.TeamResponseDTO;

import java.util.List;


public interface TeamServiceI {

    TeamResponseDTO create (TeamRequestDTO requestDTO);
    TeamResponseDTO  getById (Long id);
    List<TeamResponseDTO> getAll ();
    void  delete (Long id);
    TeamResponseDTO update(Long id, TeamRequestDTO requestDTO);
}

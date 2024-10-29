package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;

import java.util.List;

public interface StageServiceI {

    StageResponseDTO create(StageRequestDTO requestDTO);
    StageResponseDTO getById(Long id);

    List<StageResponseDTO> getAll ();
    void delete (Long id);
}

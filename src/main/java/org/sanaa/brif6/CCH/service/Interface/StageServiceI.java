package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;

import java.util.List;

public interface StageServiceI {

    StageResponseDTO create (StageResponseDTO requestDTO);
    StageResponseDTO get (Long id);
    List<StageResponseDTO> getALL ();
    StageResponseDTO update (Long id , StageRequestDTO requestDTO);
    void delete (Long id);
}

package org.sanaa.brif6.CCH.service.Interface;


import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;

import java.util.List;

public interface ResultServiceI {

    ResultResponseDTO create (ResultRequestDTO requestDTO);
    ResultResponseDTO getById (Long cyclistId, Long stageId);
    List<ResultResponseDTO> getAll ();
    void delete (Long cyclistId, Long stageId);
}

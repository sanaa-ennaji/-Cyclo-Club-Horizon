package org.sanaa.brif6.CCH.service.Interface;



import org.sanaa.brif6.CCH.dto.Request.GeneralResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.GeneralResultResponseDTO;

import java.util.List;

public interface GeneralResultServiceI {

    GeneralResultResponseDTO create (GeneralResultRequestDTO requestDTO);
    GeneralResultResponseDTO getById (Long cyclistId, Long competitionId);
    List<GeneralResultResponseDTO> getAll ();
    void delete (Long cyclistId, Long competitionId);
}

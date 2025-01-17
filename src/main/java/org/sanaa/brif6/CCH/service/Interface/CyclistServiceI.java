package org.sanaa.brif6.CCH.service.Interface;

import org.sanaa.brif6.CCH.dto.Request.CyclistRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CyclistResponseDTO;

import java.util.List;

public interface CyclistServiceI {

    CyclistResponseDTO create (CyclistRequestDTO requestDTO);
    CyclistResponseDTO getById (Long id);
    List<CyclistResponseDTO> getAll ();
    CyclistResponseDTO update (Long id , CyclistRequestDTO requestDTO);
    void delete (Long id);
}

package org.sanaa.brif6.CCH.mapper;

import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.CyclistRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CyclistResponseDTO;
import org.sanaa.brif6.CCH.entity.Cyclist;

@Mapper( componentModel = "spring")
public interface CyclistMapper {
    Cyclist toEntity(CyclistRequestDTO cyclistRequestDTO);
    CyclistResponseDTO toResponseDTO(Cyclist cyclist);






}

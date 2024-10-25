package org.sanaa.brif6.CCH.mapper;

import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.GeneralResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.GeneralResultResponseDTO;
import org.sanaa.brif6.CCH.entity.GeneralResult;

@Mapper(componentModel = "spring")
public interface GeneralResultMapper {

    GeneralResult toEntity (GeneralResultRequestDTO generalResultResultDTO);
    GeneralResultResponseDTO toResponseDTO (GeneralResult genarlResult  );




}

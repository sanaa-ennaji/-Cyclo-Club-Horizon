package org.sanaa.brif6.CCH.mapper;

import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Result;

@Mapper(componentModel = "spring"  )
public interface ResultMapper {

    Result toEntity (ResultRequestDTO resultRequestDTO);
    ResultResponseDTO toResponseDTO (Result request);


}

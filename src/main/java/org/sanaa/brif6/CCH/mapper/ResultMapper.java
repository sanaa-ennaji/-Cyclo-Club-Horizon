package org.sanaa.brif6.CCH.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Result;

@Mapper(componentModel = "spring"  )
public interface ResultMapper {

    @Mapping(target = "cyclistId", source = "id.cyclist.id")
    @Mapping(target = "stageId", source = "id.stage.id")
    @Mapping(target = "rank", source = "rank")
    @Mapping(target = "time", source = "time")
    ResultResponseDTO toResponseDTO(Result result);

    Result toEntity(ResultRequestDTO resultRequestDTO);


}

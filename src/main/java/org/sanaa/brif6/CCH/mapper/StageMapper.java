package org.sanaa.brif6.CCH.mapper;


import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;
import org.sanaa.brif6.CCH.entity.Stage;

@Mapper( componentModel =  "spring" )
public interface StageMapper {

    Stage toEntity(StageRequestDTO stageRequestDTO);
    StageResponseDTO toResponseDTO(Stage stage);
}

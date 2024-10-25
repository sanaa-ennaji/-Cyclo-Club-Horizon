package org.sanaa.brif6.CCH.mapper;


import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.entity.Result;
import org.sanaa.brif6.CCH.entity.Stage;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedResult;

@Mapper(componentModel = "spring"  )
public interface ResultMapper {

    Result toEntity (ResultRequestDTO resultRequestDTO);
    ResultResponseDTO toResponseDTO (Result request);


    default Long map(EmbeddedResult embeddedResult) {
        if (embeddedResult == null) {
            return null;
        }

        return embeddedResult.getCyclistId();
    }


    default EmbeddedResult map(Long cyclistId, Long stageId) {
        EmbeddedResult embeddedResult = new EmbeddedResult();
        Cyclist cyclist = new Cyclist();
        cyclist.setId(cyclistId);
        embeddedResult.setCyclist(cyclist);

        Stage stage = new Stage();
        stage.setId(stageId);
        embeddedResult.setStage(stage);

        return embeddedResult;
    }

}

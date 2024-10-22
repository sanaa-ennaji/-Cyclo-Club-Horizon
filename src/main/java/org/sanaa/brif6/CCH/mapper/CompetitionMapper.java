package org.sanaa.brif6.CCH.mapper;

import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {

    Competition toEntity(CompetitionRequestDTO competitionRequestDTO);
    CompetitionResponseDTO toResponseDTO(Competition competition);



}

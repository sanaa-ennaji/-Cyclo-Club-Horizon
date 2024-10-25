package org.sanaa.brif6.CCH.mapper;

import org.mapstruct.Mapper;
import org.sanaa.brif6.CCH.dto.Request.TeamRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.TeamResponseDTO;
import org.sanaa.brif6.CCH.entity.Team;

@Mapper( componentModel = "spring" )
public interface TeamMapper {

    Team toEntity (TeamRequestDTO teamRequestDTO);
    TeamResponseDTO toResponseDTO (Team team);
}
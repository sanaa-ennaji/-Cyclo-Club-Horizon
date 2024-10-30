package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.TeamRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.TeamResponseDTO;
import org.sanaa.brif6.CCH.entity.Team;
import org.sanaa.brif6.CCH.mapper.TeamMapper;
import org.sanaa.brif6.CCH.repository.TeamRepository;
import org.sanaa.brif6.CCH.service.Interface.TeamServiceI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class TeamService implements TeamServiceI {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);


    @Override
    public TeamResponseDTO create(TeamRequestDTO requestDTO) {
     Team team = teamMapper.toEntity(requestDTO);
     team = teamRepository.save(team);
        return teamMapper.toResponseDTO(team);
    }

    @Override
    public TeamResponseDTO getById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.map(teamMapper::toResponseDTO).orElse(null);
    }

    @Override
    public List<TeamResponseDTO> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(teamMapper::toResponseDTO)
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);

    }
}

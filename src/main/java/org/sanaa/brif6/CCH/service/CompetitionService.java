package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.mapper.CompetitionMapper;
import org.sanaa.brif6.CCH.repository.CompetetionRepository;
import org.sanaa.brif6.CCH.service.Interface.CompetitionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class CompetitionService implements CompetitionServiceI {

        private final CompetetionRepository competitionRepository;
        private final CompetitionMapper competitionMapper = Mappers.getMapper(CompetitionMapper.class);

        @Override
        public CompetitionResponseDTO create (CompetitionRequestDTO requestDTO){
            Competition competition =competitionMapper.toEntity(requestDTO);
            competition = competitionRepository.save(competition);
            return competitionMapper.toResponseDTO(competition);
        }


    @Override
    public CompetitionResponseDTO getById(Long id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        return competition.map(competitionMapper::toResponseDTO).orElse(null);
    }

    @Override
    public List<CompetitionResponseDTO> getAll() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competitionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionResponseDTO update(Long id, CompetitionRequestDTO requestDTO) {
        Optional<Competition> existingCompetition = competitionRepository.findById(id);

        if (existingCompetition.isPresent()) {
            Competition competitionToUpdate = existingCompetition.get();
            competitionToUpdate.setName(requestDTO.getName());
            competitionToUpdate.setStartDate(requestDTO.getStartDate());
            competitionToUpdate.setEndDate(requestDTO.getEndDate());
            competitionRepository.save(competitionToUpdate);

            return competitionMapper.toResponseDTO(competitionToUpdate);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }

    }

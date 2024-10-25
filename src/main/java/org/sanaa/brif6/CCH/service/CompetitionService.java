package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.mapper.CompetitionMapper;
import org.sanaa.brif6.CCH.repository.CompetetionRepository;
import org.sanaa.brif6.CCH.service.Interface.CompetitionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
    @Transactional
    public class CompetitionService implements CompetitionServiceI {

        private final CompetetionRepository competitionRepository;
        private final CompetitionMapper competitionMapper = Mappers.getMapper(CompetitionMapper.class);


        @Autowired
        public CompetitionService(CompetetionRepository competitionRepository)
        {
            this.competitionRepository = competitionRepository;
        }
        @Override
        public CompetitionResponseDTO create (CompetitionRequestDTO requestDTO){
            Competition competition =competitionMapper.toEntity(requestDTO);
            competition = competitionRepository.save(competition);
            return competitionMapper.toResponseDTO(competition);
        }


    @Override
    public CompetitionResponseDTO getCompetitionById(Long id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        return competition.map(competitionMapper::toResponseDTO).orElse(null); // Handle not found case
    }

    @Override
    public List<CompetitionResponseDTO> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competitionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionResponseDTO updateCompetition(Long id, CompetitionRequestDTO requestDTO) {
        Optional<Competition> existingCompetition = competitionRepository.findById(id);

        if (existingCompetition.isPresent()) {
            Competition competitionToUpdate = existingCompetition.get();
            competitionToUpdate.setName(requestDTO.getName());
          //  competitionToUpdate.setDescription(requestDTO.getDescription());
            competitionToUpdate.setStartDate(requestDTO.getStartDate());
            competitionToUpdate.setEndDate(requestDTO.getEndDate());
            competitionRepository.save(competitionToUpdate);

            return competitionMapper.toResponseDTO(competitionToUpdate);
        }
        return null;
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    }

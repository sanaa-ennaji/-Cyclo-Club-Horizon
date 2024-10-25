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

    }

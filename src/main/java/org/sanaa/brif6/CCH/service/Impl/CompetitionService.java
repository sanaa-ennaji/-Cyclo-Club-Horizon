package org.sanaa.brif6.CCH.service.Impl;


import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.mapper.CompetitionMapper;
import org.sanaa.brif6.CCH.repository.CompetitionRepository;
import org.sanaa.brif6.CCH.service.CompetitionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompetitionService implements CompetitionServiceI {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper  competitionMapper = Mappers.getMapper(CompetitionMapper.class);


    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository)
    {
        this.competitionRepository = competitionRepository;
    }

public CompetitionResponseDTO create (CompetitionRequestDTO requestDTO){
      Competition competition =competitionMapper.toEntity(requestDTO);
    competition = competitionRepository.save(competition);
      return competitionMapper.toResponseDTO(competition);
}




}

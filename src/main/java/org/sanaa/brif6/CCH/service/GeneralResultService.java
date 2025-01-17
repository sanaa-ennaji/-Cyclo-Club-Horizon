package org.sanaa.brif6.CCH.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.GeneralResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.GeneralResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.entity.GeneralResult;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedGeneralResult;
import org.sanaa.brif6.CCH.mapper.GeneralResultMapper;
import org.sanaa.brif6.CCH.repository.CompetetionRepository;
import org.sanaa.brif6.CCH.repository.CyclistRepository;
import org.sanaa.brif6.CCH.repository.GeneralResultRepository;
import org.sanaa.brif6.CCH.service.Interface.GeneralResultServiceI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class GeneralResultService implements GeneralResultServiceI {

    private final GeneralResultRepository generalResultRepository;
    private final GeneralResultMapper generalResultMapper;
    private final CyclistRepository cyclistRepository; //service
    private final CompetetionRepository competitionRepository; // service

    @Override
    public GeneralResultResponseDTO create(GeneralResultRequestDTO requestDTO) {
        GeneralResult generalResult = generalResultMapper.toEntity(requestDTO);
        generalResult = generalResultRepository.save(generalResult);
        return generalResultMapper.toResponseDTO(generalResult);
    }

    @Override
    public GeneralResultResponseDTO getById(Long cyclistId, Long competitionId) {

        Cyclist cyclist = cyclistRepository.findById(cyclistId)
                .orElseThrow(() -> new EntityNotFoundException("Cyclist not found with id: " + cyclistId));
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with id: " + competitionId));


        EmbeddedGeneralResult id = new EmbeddedGeneralResult();
        id.setCyclist(cyclist);
        id.setCompetition(competition);


        Optional<GeneralResult> generalResult = generalResultRepository.findById(id);
        return generalResult.map(generalResultMapper::toResponseDTO).orElse(null);
    }

    @Override
    public List<GeneralResultResponseDTO> getAll() {
        List<GeneralResult> generalResults = generalResultRepository.findAll();
        return generalResults.stream()
                .map(generalResultMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long cyclistId, Long competitionId) {

        Cyclist cyclist = cyclistRepository.findById(cyclistId)
                .orElseThrow(() -> new EntityNotFoundException("Cyclist not found with id: " + cyclistId));
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with id: " + competitionId));


        EmbeddedGeneralResult id = new EmbeddedGeneralResult();
        id.setCyclist(cyclist);
        id.setCompetition(competition);


        generalResultRepository.deleteById(id);
    }
}

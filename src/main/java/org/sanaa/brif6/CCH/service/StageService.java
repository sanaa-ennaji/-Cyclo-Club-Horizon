package org.sanaa.brif6.CCH.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.entity.Stage;
import org.sanaa.brif6.CCH.mapper.StageMapper;
import org.sanaa.brif6.CCH.repository.CompetetionRepository;
import org.sanaa.brif6.CCH.repository.StageRepository;
import org.sanaa.brif6.CCH.service.Interface.StageServiceI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class StageService implements StageServiceI {
    private final StageRepository stageRepository;
    private final StageMapper stageMapper;
    private final CompetetionRepository competitionRepository;

    @Override
    public StageResponseDTO create(StageRequestDTO requestDTO) {
        final Competition competition = competitionRepository.findById(requestDTO.getCompetitionId())
                .orElseThrow(() -> new EntityNotFoundException("Competition with ID " + requestDTO.getCompetitionId() + " not found."));
        Stage stage = stageMapper.toEntity(requestDTO);
        stage.setCompetition(competition);
        stage = stageRepository.save(stage);
        return stageMapper.toResponseDTO(stage);
    }


    @Override
    public StageResponseDTO getById(Long id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stage.map(stageMapper::toResponseDTO).orElse(null);
    }

    @Override
    public List<StageResponseDTO> getAll() {
        List<Stage> stages = stageRepository.findAll();
        return stages.stream()
                .map(stageMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        stageRepository.deleteById(id);
    }
}

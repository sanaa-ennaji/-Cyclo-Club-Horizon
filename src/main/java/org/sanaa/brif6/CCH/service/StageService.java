package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;
import org.sanaa.brif6.CCH.entity.Stage;
import org.sanaa.brif6.CCH.mapper.StageMapper;
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
    private final StageMapper stageMapper = Mappers.getMapper(StageMapper.class);

    @Override
    public StageResponseDTO create(StageRequestDTO requestDTO) {
        Stage stage = stageMapper.toEntity(requestDTO);
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

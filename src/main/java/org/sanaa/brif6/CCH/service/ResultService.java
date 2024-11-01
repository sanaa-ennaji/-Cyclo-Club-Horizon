package org.sanaa.brif6.CCH.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.entity.Result;
import org.sanaa.brif6.CCH.entity.Stage;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedResult;
import org.sanaa.brif6.CCH.mapper.ResultMapper;
import org.sanaa.brif6.CCH.repository.CyclistRepository;
import org.sanaa.brif6.CCH.repository.ResultRepository;
import org.sanaa.brif6.CCH.repository.StageRepository;
import org.sanaa.brif6.CCH.service.Interface.ResultServiceI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class ResultService  implements ResultServiceI {
    private final CyclistRepository cyclistRepository;
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper ;
    private final StageRepository stageRepository;

    @Override
    public ResultResponseDTO create(ResultRequestDTO requestDTO) {
        Cyclist cyclist = cyclistRepository.findById(requestDTO.getCyclistId())
                .orElseThrow(() -> new EntityNotFoundException("Cyclist with ID " + requestDTO.getCyclistId() + " not found."));
        Stage stage = stageRepository.findById(requestDTO.getStageId())
                .orElseThrow(() -> new EntityNotFoundException("Stage with ID " + requestDTO.getStageId() + " not found."));
        EmbeddedResult embeddedId = new EmbeddedResult();
        embeddedId.setCyclist(cyclist);
        embeddedId.setStage(stage);
        Result result = resultMapper.toEntity(requestDTO);
        result.setId(embeddedId);
        result = resultRepository.save(result);
        return resultMapper.toResponseDTO(result);
    }

    @Override
    public ResultResponseDTO getById(Long cyclistId, Long stageId) {
        EmbeddedResult id = new EmbeddedResult();
        Optional<Result> result = resultRepository.findById(id);
        return result.map(resultMapper::toResponseDTO).orElse(null);
    }

    @Override
    public List<ResultResponseDTO> getAll() {
        List<Result> results = resultRepository.findAll();
        return results.stream()
                .map(resultMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long cyclistId, Long stageId) {
        EmbeddedResult id = new EmbeddedResult();
        resultRepository.deleteById(id);
    }
}

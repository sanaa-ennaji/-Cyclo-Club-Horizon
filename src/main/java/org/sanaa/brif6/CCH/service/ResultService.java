package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.entity.Result;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedResult;
import org.sanaa.brif6.CCH.mapper.ResultMapper;
import org.sanaa.brif6.CCH.repository.ResultRepository;
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

    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper = Mappers.getMapper(ResultMapper.class);

    @Override
    public ResultResponseDTO create(ResultRequestDTO requestDTO) {
        Result result = resultMapper.toEntity(requestDTO);
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

package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.GeneralResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.GeneralResultResponseDTO;
import org.sanaa.brif6.CCH.entity.GeneralResult;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedGeneralResult;
import org.sanaa.brif6.CCH.mapper.GeneralResultMapper;
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
        private final GeneralResultMapper generalResultMapper = Mappers.getMapper(GeneralResultMapper.class);

        @Override
        public GeneralResultResponseDTO create(GeneralResultRequestDTO requestDTO) {
            GeneralResult generalResult = generalResultMapper.toEntity(requestDTO);
            generalResult = generalResultRepository.save(generalResult);
            return generalResultMapper.toResponseDTO(generalResult);
        }

        @Override
        public GeneralResultResponseDTO getById(Long cyclistId, Long competitionId) {
            EmbeddedGeneralResult id = new EmbeddedGeneralResult();
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
            EmbeddedGeneralResult id = new EmbeddedGeneralResult();
            generalResultRepository.deleteById(id);
        }
}

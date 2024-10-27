package org.sanaa.brif6.CCH.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sanaa.brif6.CCH.dto.Request.CyclistRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CyclistResponseDTO;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.mapper.CyclistMapper;
import org.sanaa.brif6.CCH.repository.CyclistRepository;

import org.sanaa.brif6.CCH.service.Interface.CyclistServiceI;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class CyclistService implements CyclistServiceI {

    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper = Mappers.getMapper(CyclistMapper.class);

    @Override
    public CyclistResponseDTO create(CyclistRequestDTO requestDTO) {
        Cyclist cyclist = cyclistMapper.toEntity(requestDTO);
        cyclist = cyclistRepository.save(cyclist);
        return cyclistMapper.toResponseDTO(cyclist);
    }


    @Override
    public List<CyclistResponseDTO> getAll() {
        List<Cyclist> cyclists = cyclistRepository.findAll();
        return cyclists.stream()
                .map(cyclistMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CyclistResponseDTO getById(Long id) {
        Optional<Cyclist> cyclist = cyclistRepository.findById(id);
        return cyclist.map(cyclistMapper::toResponseDTO).orElse(null);
    }
    @Override
    public CyclistResponseDTO update(Long id, CyclistRequestDTO requestDTO) {
        Optional<Cyclist> existingCyclist = cyclistRepository.findById(id);

        if (existingCyclist.isPresent()) {
            Cyclist cyclistToUpdate = existingCyclist.get();
            cyclistToUpdate.setName(requestDTO.getName());
            cyclistToUpdate.setLastName(requestDTO.getLastName());
            cyclistToUpdate.setAge(requestDTO.getAge());
            cyclistRepository.save(cyclistToUpdate);

            return cyclistMapper.toResponseDTO(cyclistToUpdate);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        cyclistRepository.deleteById(id);
    }



}

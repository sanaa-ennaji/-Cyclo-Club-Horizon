package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sanaa.brif6.CCH.dto.Request.CyclistRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CyclistResponseDTO;
import org.sanaa.brif6.CCH.entity.Cyclist;
import org.sanaa.brif6.CCH.mapper.CyclistMapper;
import org.sanaa.brif6.CCH.repository.CyclistRepository;
import org.sanaa.brif6.CCH.service.CyclistService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CyclistServiceTest {
    @Mock
    private CyclistRepository cyclistRepository;

    @Mock
    private CyclistMapper cyclistMapper;

    @InjectMocks
    private CyclistService cyclistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateCyclist() {
        CyclistRequestDTO requestDTO = new CyclistRequestDTO();
        Cyclist cyclist = new Cyclist();
        CyclistResponseDTO responseDTO = new CyclistResponseDTO();

        when(cyclistMapper.toEntity(requestDTO)).thenReturn(cyclist);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);
        when(cyclistMapper.toResponseDTO(cyclist)).thenReturn(responseDTO);

        CyclistResponseDTO result = cyclistService.create(requestDTO);

        assertNotNull(result);
        verify(cyclistRepository, times(1)).save(cyclist);
    }

    @Test
    void testGetCyclistById() {
        Long id = 1L;
        Cyclist cyclist = new Cyclist();
        CyclistResponseDTO responseDTO = new CyclistResponseDTO();

        when(cyclistRepository.findById(id)).thenReturn(Optional.of(cyclist));
        when(cyclistMapper.toResponseDTO(cyclist)).thenReturn(responseDTO);

        CyclistResponseDTO result = cyclistService.getById(id);

        assertNotNull(result);
        verify(cyclistRepository, times(1)).findById(id);
    }

    @Test
    void testGetAllCyclists() {
        Cyclist cyclist1 = new Cyclist();
        Cyclist cyclist2 = new Cyclist();
        List<Cyclist> cyclists = Arrays.asList(cyclist1, cyclist2);

        CyclistResponseDTO responseDTO1 = new CyclistResponseDTO();
        CyclistResponseDTO responseDTO2 = new CyclistResponseDTO();

        when(cyclistRepository.findAll()).thenReturn(cyclists);
        when(cyclistMapper.toResponseDTO(cyclist1)).thenReturn(responseDTO1);
        when(cyclistMapper.toResponseDTO(cyclist2)).thenReturn(responseDTO2);

        List<CyclistResponseDTO> result = cyclistService.getAll();

        assertEquals(2, result.size());
        verify(cyclistRepository, times(1)).findAll();
    }

    @Test
    void testDeleteCyclist() {
        Long id = 1L;

        cyclistService.delete(id);

        verify(cyclistRepository, times(1)).deleteById(id);
    }

}

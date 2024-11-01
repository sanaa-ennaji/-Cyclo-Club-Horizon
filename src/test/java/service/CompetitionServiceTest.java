package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.entity.Competition;
import org.sanaa.brif6.CCH.repository.CompetetionRepository;
import org.sanaa.brif6.CCH.mapper.CompetitionMapper;
import org.sanaa.brif6.CCH.service.CompetitionService;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
public class CompetitionServiceTest {

    @Mock
    private CompetetionRepository competitionRepository;

    @Mock
    private CompetitionMapper competitionMapper;

    @InjectMocks
    private CompetitionService competitionService;

    @Test
    void shouldCreateCompetitionSuccessfully() {

        CompetitionRequestDTO requestDTO = new CompetitionRequestDTO();
        requestDTO.setName("Tour de France");

        Competition competition = new Competition();
        competition.setId(1L);
        competition.setName(requestDTO.getName());

        CompetitionResponseDTO expectedResponse = new CompetitionResponseDTO();
        expectedResponse.setId(competition.getId());
        expectedResponse.setName(competition.getName());
        when(competitionMapper.toEntity(requestDTO)).thenReturn(competition);
        when(competitionRepository.save(competition)).thenReturn(competition);
        when(competitionMapper.toResponseDTO(competition)).thenReturn(expectedResponse);
        CompetitionResponseDTO actualResponse = competitionService.create(requestDTO);
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse.getName(), actualResponse.getName());
        verify(competitionRepository, times(1)).save(competition);
    }

    @Test
    void shouldThrowExceptionWhenRequestDTONull() {
        CompetitionRequestDTO requestDTO = null;
        assertThrows(IllegalArgumentException.class, () -> competitionService.create(requestDTO));
    }

    @Test
    void shouldThrowExceptionWhenRequiredFieldsMissing() {
        CompetitionRequestDTO requestDTO = new CompetitionRequestDTO();
        when(competitionMapper.toEntity(requestDTO)).thenThrow(new ConstraintViolationException("Name is required", null));
        assertThrows(ConstraintViolationException.class, () -> competitionService.create(requestDTO));
    }
}

package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.GeneralResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.GeneralResultResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.GeneralResultServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/generalResults")
@RequiredArgsConstructor
public class GeneralResultController {

    private final GeneralResultServiceI generalResultService;

    @PostMapping
    public ResponseEntity<GeneralResultResponseDTO> createGeneralResult(@RequestBody GeneralResultRequestDTO requestDTO) {
        GeneralResultResponseDTO responseDTO = generalResultService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{cyclistId}/{competitionId}")
    public ResponseEntity<GeneralResultResponseDTO> getGeneralResultById(
            @PathVariable Long cyclistId,
            @PathVariable Long competitionId) {
        GeneralResultResponseDTO responseDTO = generalResultService.getById(cyclistId, competitionId);
        return responseDTO != null ? new ResponseEntity<>(responseDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<GeneralResultResponseDTO>> getAllGeneralResults() {
        List<GeneralResultResponseDTO> results = generalResultService.getAll();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @DeleteMapping("/{cyclistId}/{competitionId}")
    public ResponseEntity<Void> deleteGeneralResult(
            @PathVariable Long cyclistId,
            @PathVariable Long competitionId) {
        generalResultService.delete(cyclistId, competitionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

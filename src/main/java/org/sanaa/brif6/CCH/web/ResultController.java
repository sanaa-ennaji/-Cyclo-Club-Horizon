package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.ResultRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.ResultResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.ResultServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultServiceI resultService;

    @PostMapping
    public ResponseEntity<ResultResponseDTO> create(@RequestBody ResultRequestDTO requestDTO) {
        ResultResponseDTO responseDTO = resultService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{cyclistId}/{stageId}")
    public ResponseEntity<ResultResponseDTO> getById(
            @PathVariable Long cyclistId,
            @PathVariable Long stageId) {
        ResultResponseDTO responseDTO = resultService.getById(cyclistId, stageId);
        return responseDTO != null ? new ResponseEntity<>(responseDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ResultResponseDTO>> getAll() {
        List<ResultResponseDTO> results = resultService.getAll();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @DeleteMapping("/{cyclistId}/{stageId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long cyclistId,
            @PathVariable Long stageId) {
        resultService.delete(cyclistId, stageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

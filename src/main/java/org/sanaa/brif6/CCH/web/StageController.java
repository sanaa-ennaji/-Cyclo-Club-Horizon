package org.sanaa.brif6.CCH.web;


import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.StageRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.StageResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.StageServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
@RequiredArgsConstructor
public class StageController {
    private final StageServiceI stageService;

    @PostMapping
    public ResponseEntity<StageResponseDTO> create(@RequestBody StageRequestDTO requestDTO) {
        StageResponseDTO responseDTO = stageService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageResponseDTO> getById(@PathVariable Long id) {
        StageResponseDTO responseDTO = stageService.getById(id);
        return responseDTO != null ? new ResponseEntity<>(responseDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<StageResponseDTO>> getAll() {
        List<StageResponseDTO> stages = stageService.getAll();
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

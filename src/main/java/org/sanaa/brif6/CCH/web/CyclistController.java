package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.CyclistRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CyclistResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.CyclistServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cyclists")
@RequiredArgsConstructor
public class CyclistController {

    private final CyclistServiceI cyclistService;

    @PostMapping
    public ResponseEntity<CyclistResponseDTO> createCyclist(@RequestBody CyclistRequestDTO requestDTO) {
        CyclistResponseDTO responseDTO = cyclistService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> getCyclistById(@PathVariable Long id) {
        CyclistResponseDTO responseDTO = cyclistService.getById(id);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CyclistResponseDTO>> getAllCyclists() {
        List<CyclistResponseDTO> cyclists = cyclistService.getAll();
        return new ResponseEntity<>(cyclists, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> updateCyclist(
            @PathVariable Long id, @RequestBody CyclistRequestDTO requestDTO) {
        CyclistResponseDTO responseDTO = cyclistService.update(id, requestDTO);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCyclist(@PathVariable Long id) {
        cyclistService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
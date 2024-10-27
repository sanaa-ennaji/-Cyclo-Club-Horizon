package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;

import org.sanaa.brif6.CCH.service.Interface.CompetitionServiceI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionServiceI competitionService;

    @PostMapping("/create")
    public ResponseEntity<CompetitionResponseDTO> create(@RequestBody CompetitionRequestDTO requestDTO) {
        try {
            CompetitionResponseDTO responseDTO = competitionService.create(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponseDTO> getById(@PathVariable Long id) {
        CompetitionResponseDTO responseDTO = competitionService.getById(id);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public ResponseEntity<List<CompetitionResponseDTO>> getAll() {
        List<CompetitionResponseDTO> responseDTOList = competitionService.getAll();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponseDTO> update(
            @PathVariable Long id, @RequestBody CompetitionRequestDTO requestDTO) {
        CompetitionResponseDTO responseDTO = competitionService.update(id, requestDTO);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competitionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
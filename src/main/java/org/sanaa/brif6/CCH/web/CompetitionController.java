package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.service.CompetitionService;
import org.sanaa.brif6.CCH.service.Interface.CompetitionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionServiceI competitionService;

    @PostMapping("/create")
    public ResponseEntity<CompetitionResponseDTO> createCompetition(@RequestBody CompetitionRequestDTO requestDTO) {
        try {
            CompetitionResponseDTO responseDTO = competitionService.create(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<CompetitionResponseDTO> getCompetitionById(@PathVariable Long id) {
//        CompetitionResponseDTO responseDTO = competitionService.getCompetitionById(id);
//        if (responseDTO != null) {
//            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Get all competitions
//    @GetMapping
//    public ResponseEntity<List<CompetitionResponseDTO>> getAllCompetitions() {
//        List<CompetitionResponseDTO> responseDTOList = competitionService.getAllCompetitions();
//        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
//    }
//
//    // Update a competition
//    @PutMapping("/{id}")
//    public ResponseEntity<CompetitionResponseDTO> updateCompetition(
//            @PathVariable Long id, @RequestBody CompetitionRequestDTO requestDTO) {
//        CompetitionResponseDTO responseDTO = competitionService.updateCompetition(id, requestDTO);
//        if (responseDTO != null) {
//            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
//        competitionService.deleteCompetition(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


}
package org.sanaa.brif6.CCH.web;

import lombok.RequiredArgsConstructor;
import org.sanaa.brif6.CCH.dto.Request.TeamRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.TeamResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.TeamServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamServiceI teamService;

    @PostMapping("/create")
    public ResponseEntity<TeamResponseDTO> create(@RequestBody TeamRequestDTO requestDTO) {
        try {
            TeamResponseDTO responseDTO = teamService.create(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getById(@PathVariable Long id) {
        TeamResponseDTO responseDTO = teamService.getById(id);
        if (responseDTO != null){
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    } else

    {
      return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }
}

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAll() {
        List<TeamResponseDTO> responseDTOList = teamService.getAll();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> update(
            @PathVariable Long id, @RequestBody TeamRequestDTO requestDTO) {
      TeamResponseDTO responseDTO = teamService.update(id, requestDTO);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

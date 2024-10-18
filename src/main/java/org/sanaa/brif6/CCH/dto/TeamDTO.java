package org.sanaa.brif6.CCH.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDTO {

    private Long id ;
    private String teamName;
    private List<CyclistDTO> cyclists ;
}

package org.sanaa.brif6.CCH.dto.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TeamRequestDTO {

    @NotBlank(message = "Team name is required")
    private String teamName;

    @NotBlank(message = "Nationality is required")
    private String nationality;


}

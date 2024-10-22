package org.sanaa.brif6.CCH.dto.Response;

import lombok.Getter;
import lombok.Setter;
import org.sanaa.brif6.CCH.entity.Cyclist;

import java.util.List;
@Getter
@Setter
public class TeamResponseDTO {
    private String teamName ;
    private String nationality;
    private List<Cyclist> cyclistNames;
}

package org.sanaa.brif6.CCH;

import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.service.CompetitionServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sanaa.brif6.CCH.config.AppConfig;

import java.time.LocalDate;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CompetitionServiceI competitionService = context.getBean(CompetitionServiceI.class);

        CompetitionRequestDTO requestDTO = new CompetitionRequestDTO();
        try {
            requestDTO.setName("france");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            requestDTO.setStartDate(LocalDate.parse("2024-3-3"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        requestDTO.setEndDate(LocalDate.parse("2024-5-4"));

        CompetitionResponseDTO responseDTO = competitionService.create(requestDTO);







        System.out.println( "Hello World!" );
    }
}

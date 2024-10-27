package org.sanaa.brif6.CCH;

import org.sanaa.brif6.CCH.config.AppConfig;
import org.sanaa.brif6.CCH.dto.Request.CompetitionRequestDTO;
import org.sanaa.brif6.CCH.dto.Response.CompetitionResponseDTO;
import org.sanaa.brif6.CCH.service.Interface.CompetitionServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CompetitionServiceI competitionService = context.getBean(CompetitionServiceI.class);

        CompetitionRequestDTO requestDTO = new CompetitionRequestDTO();
        requestDTO.setName("France Tour");
        requestDTO.setStartDate(LocalDate.parse("2024-03-03"));
        requestDTO.setEndDate(LocalDate.parse("2024-05-04"));


        CompetitionResponseDTO responseDTO = competitionService.create(requestDTO);


        System.out.println("Competition created:");
        System.out.println("ID: " + responseDTO.getId());
        System.out.println("Name: " + responseDTO.getName());
        System.out.println("Start Date: " + responseDTO.getStartDate());
        System.out.println("End Date: " + responseDTO.getEndDate());
    }
}
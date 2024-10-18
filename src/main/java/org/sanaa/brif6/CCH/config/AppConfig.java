package org.sanaa.brif6.CCH.config;


import org.sanaa.brif6.CCH.service.Impl.cyclistService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.sanaa.brif6.CCH")

public class AppConfig {

    @Bean
    public org.sanaa.brif6.CCH.service.cyclistService cyclistService (){
        return (org.sanaa.brif6.CCH.service.cyclistService) new cyclistService();
    }






}

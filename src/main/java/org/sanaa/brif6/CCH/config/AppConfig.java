package org.sanaa.brif6.CCH.config;


import org.sanaa.brif6.CCH.service.Impl.cyclistService;
import org.sanaa.brif6.CCH.service.cyclistServiceI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.sanaa.brif6.CCH")
public class AppConfig {

    @Bean
    public cyclistServiceI cyclistService (){
        return (cyclistServiceI) new cyclistService();
    }






}

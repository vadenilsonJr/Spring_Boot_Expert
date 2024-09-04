package io.github.vedenilsonjr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("develop")
public class MyConfiguration {

   @Bean(name = "applicationName")
    public CommandLineRunner executar(){
       return args -> {
           System.out.println("Ultilizando configuração de desenvolvimento");
       };
   }
  }

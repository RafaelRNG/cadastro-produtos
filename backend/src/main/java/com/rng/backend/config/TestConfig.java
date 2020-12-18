package com.rng.backend.config;

import com.rng.backend.service.database.StartDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {

    @Autowired
    private StartDatabase startDatabase;

    @Bean
    public boolean start(){
        startDatabase.StartDB();

        return true;
    }
}
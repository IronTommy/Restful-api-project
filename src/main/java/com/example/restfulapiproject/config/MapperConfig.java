package com.example.restfulapiproject.config;

import com.example.restfulapiproject.mapper.TaskMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public TaskMapper taskMapper() {
        return TaskMapper.INSTANCE;
    }
}

package com.versusmind.demo.infrastructure.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Slf4j
@Configuration
public class JpaPopulators {

    @Value("${app.populator.datasDir}")
    private String path;

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        Resource[] files = new Resource[]{};

        try {
            File dir = new ClassPathResource(path).getFile();
            files = Stream.of(dir.listFiles())
                    .filter(f -> !f.isDirectory() && f.getName().contains(".json"))
                    .map(f -> new ClassPathResource(path + '/' + f.getName()))
                    .toArray(Resource[]::new);

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        factory.setResources(files);
        return factory;
    }
}
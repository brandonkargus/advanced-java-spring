package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/fish.xml"})
public class CoreLabConfig {

    @Bean
    public RodReel rodReel() {
        return new RodReel("St. Croix - 6'6\"", "Pflueger President 30");
    }
}


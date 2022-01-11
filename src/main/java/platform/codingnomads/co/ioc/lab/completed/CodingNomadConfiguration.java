package platform.codingnomads.co.ioc.lab.completed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.completed")
public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.6.2").build();
    }

    @Bean
    public IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("2021.1").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("Corretto").version("11.0.12").build();
    }

    @Bean
    public OperatingSystem operatingSystem() {
        return OperatingSystem.builder().name("Windows").version("11").build();
    }

    @Bean
    public SoundSystem soundSystem() {
        return SoundSystem.builder().type("Headphones").brand("Bose").build();
    }
    @Bean
    public Monitor monitor() {
        return Monitor.builder().manufacturer("MSI").model("Optix MAG321 CQR").build();
    }
    @Bean
    public PC pc() {
        return PC.builder().manufacturer("Microsoft").model("Surface Pro 6").build();
    }
}

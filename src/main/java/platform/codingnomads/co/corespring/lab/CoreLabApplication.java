package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CoreLabConfig.class);

        RodReel rodReel = ctx.getBean(RodReel.class);

        System.out.println("I went fishing this afternoon with my " + rodReel.getRod() + " rod, and " + rodReel.getReel() + " reel combo.");

        String[] fish = ctx.getBeanNamesForType(Fish.class);

        for(String f : fish) {
            System.out.println("I caught a " + ctx.getBean(f, Fish.class).getSize() + " " + ctx.getBean(f, Fish.class).getSpecies() + ".  The biggest of my life!");
        }
        System.out.println("What a great day of fishing!");

    }

}

package platform.codingnomads.co.springdata.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.domain.Area;
import platform.codingnomads.co.springdata.lab.domain.ParkZone;
import platform.codingnomads.co.springdata.lab.domain.Trail;
import platform.codingnomads.co.springdata.lab.repository.AreaRepository;
import platform.codingnomads.co.springdata.lab.repository.ParkZoneRepository;
import platform.codingnomads.co.springdata.lab.repository.TrailRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataLab implements CommandLineRunner {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    TrailRepository trailRepository;

    @Autowired
    ParkZoneRepository parkZoneRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {
        if (areaRepository.findAll().isEmpty()) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").summer(false).winter(true).build(),
                            Area.builder().code("H").summer(false).winter(true).build(),
                            Area.builder().code("Y").summer(false).winter(true).build(),
                            Area.builder().code("Z").summer(false).winter(true).build(),
                            Area.builder().code("B").summer(true).winter(false).build(),  //"summer" areas are A, B, C, D
                            Area.builder().code("C").summer(true).winter(false).build(),
                            Area.builder().code("A").summer(true).winter(false).build(),
                            Area.builder().code("D").summer(true).winter(false).build()
                    )
            );
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        if (trailRepository.findAll().isEmpty()) {
            Area areaG = areaRepository.findByCode("G");
            Area areaH = areaRepository.findByCode("H");
            Trail route = new Trail(areaG, areaH);
            trailRepository.save(route);


            Area areaY = areaRepository.findByCode("Y");
            Area areaZ = areaRepository.findByCode("Z");
            Trail route2 = new Trail(areaY, areaZ);
            trailRepository.save(route2);


            //"summer" routes are A-B and C-D
            Area areaA = areaRepository.findByCode("A");
            Area areaB = areaRepository.findByCode("B");
            Trail route5 = new Trail(areaA, areaB);
            trailRepository.save(route5);

            Area areaC = areaRepository.findByCode("C");
            Area areaD = areaRepository.findByCode("D");
            Trail route6 = new Trail(areaC, areaD);
            trailRepository.save(route6);

            System.out.println(trailRepository.findByOrigin_code("G"));
            System.out.println(trailRepository.findByDestination_code("Z"));
            System.out.println(trailRepository.findByCode("H-Y"));

        }
        System.out.println("--------------------------------------");

        if (parkZoneRepository.findAll().isEmpty()) {
            ParkZone northZone = new ParkZone("North Zone");
            Area areaA = areaRepository.findByCode("A");
            Area areaB = areaRepository.findByCode("B");
            northZone.setAreaList(List.of(areaA, areaB));
            Trail route5 = trailRepository.findByCode("A-B");
            northZone.setTrailList(List.of(route5));
            parkZoneRepository.save(northZone);

            ParkZone eastZone = new ParkZone("East Zone");
            Area areaC = areaRepository.findByCode("C");
            Area areaD = areaRepository.findByCode("D");
            northZone.setAreaList(List.of(areaC, areaD));
            Trail route6 = trailRepository.findByCode("C-D");
            eastZone.setAreaList(List.of(areaC, areaD));      //north and east are summer
            eastZone.setTrailList(List.of(route6));
            parkZoneRepository.save(eastZone);

            ParkZone southZone = new ParkZone("South Zone");
            Area areaG = areaRepository.findByCode("G");
            Area areaH = areaRepository.findByCode("H");
            northZone.setAreaList(List.of(areaG, areaH));
            Trail route = trailRepository.findByCode("G-H");                   //south and west are winter
            southZone.setAreaList(List.of(areaG, areaH));
            southZone.setTrailList(List.of(route));
            parkZoneRepository.save(southZone);

            ParkZone westZone = new ParkZone("West Zone");
            Area areaY = areaRepository.findByCode("Y");
            Area areaZ = areaRepository.findByCode("Z");
            northZone.setAreaList(List.of(areaA, areaB));
            Trail route2 = trailRepository.findByCode("Y-Z");
            westZone.setAreaList(List.of(areaY, areaZ));
            westZone.setTrailList(List.of(route2));
            parkZoneRepository.save(westZone);

        }

        List<ParkZone> openInSummer = parkZoneRepository.findByAreaList_summerTrue();
        List<ParkZone> openInWinter = parkZoneRepository.findByAreaList_winterTrue();

        List<ParkZone> uniqueSummer = new ArrayList<>();
        List<ParkZone> uniqueWinter = new ArrayList<>();

        for (ParkZone parkZone : openInSummer) {
            if (!uniqueSummer.contains(parkZone)) {
                uniqueSummer.add(parkZone);
            }
        }

        for (ParkZone parkZone : openInWinter) {
            if (!uniqueWinter.contains(parkZone)) {
                uniqueWinter.add(parkZone);
            }
        }

        System.out.println("Park zones open in summer are:");
        System.out.println(uniqueSummer);
        System.out.println("---------------");
        System.out.println("Park zones open in winter are:");
        System.out.println(uniqueWinter);

    }

}


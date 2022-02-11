package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.domain.ParkZone;

import java.util.List;

@Repository
public interface ParkZoneRepository extends JpaRepository<ParkZone, Long> {

    List<ParkZone> findByAreaList_summerTrue();

    List<ParkZone> findByAreaList_winterTrue();

}

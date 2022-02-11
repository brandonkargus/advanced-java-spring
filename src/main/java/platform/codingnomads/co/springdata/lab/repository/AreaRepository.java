package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    Area findByCode(String code);
}

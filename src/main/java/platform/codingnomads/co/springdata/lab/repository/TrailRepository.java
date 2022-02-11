package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.domain.Trail;

import java.util.List;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {
    List<Trail> findByOrigin_code(String code);

    List<Trail> findByDestination_code(String code);

    Trail findByCode(String code);


}

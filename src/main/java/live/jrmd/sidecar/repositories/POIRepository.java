package live.jrmd.sidecar.repositories;

import live.jrmd.sidecar.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {
    List<POI> findAllByNameIsLike(String term);
}

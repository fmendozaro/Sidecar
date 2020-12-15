package live.jrmd.sidecar.repositories;

import live.jrmd.sidecar.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByTitleIsLike(String term);
}

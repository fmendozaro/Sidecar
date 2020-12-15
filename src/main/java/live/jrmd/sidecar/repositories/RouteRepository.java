package live.jrmd.sidecar.repositories;

import live.jrmd.sidecar.models.Route;
import live.jrmd.sidecar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByTitleIsLike(String term);

    Object findAllByUser(User user);
}

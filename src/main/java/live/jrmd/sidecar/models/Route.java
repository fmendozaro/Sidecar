package live.jrmd.sidecar.models;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.List;

@Entity
@Table(name="routes")
public class Route {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 15)
    private String distance;

    @Column(nullable = false, length = 25)
    private String time;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String api_url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<RouteComment> routeComments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Route() {}

    //write
    public Route(String title, String distance, String time, String description, String api_url) {
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.description = description;
        this.api_url = api_url;
    }

    //read
    public Route(long id, String title, String distance, String time, String description, String api_url) {
        this.id = id;
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.description = description;
        this.api_url = api_url;
    }

    public long getId () {
        return this.id;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String newDistance) {
        this.distance = newDistance;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String newTime) {
        this.time = time;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public String getApi_url() {
        return this.api_url;
    }

    public void setApi_url(String newApi_Url) {
        this.api_url = newApi_Url;
    }

    public List<RouteComment> getRouteComments() {
        return routeComments;
    }

    public void setRouteComments(List<RouteComment> routeComments) {
        this.routeComments = routeComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

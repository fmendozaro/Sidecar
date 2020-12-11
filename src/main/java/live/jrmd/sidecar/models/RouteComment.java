package live.jrmd.sidecar.models;

import javax.persistence.*;

@Entity
@Table(name="route_comments")
public class RouteComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, columnDefinition = "LONGTEXT")
    private String comment;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private String timestamp;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "route_id")
    private Route route;

    public RouteComment() {}

    //write
    public RouteComment(String comment, String timestamp) {
        this.comment = comment;
        this.timestamp = timestamp;
    }

    //read
    public RouteComment(long id, String comment, String timestamp) {
        this.id = id;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}

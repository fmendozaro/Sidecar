package live.jrmd.sidecar.models;

import javax.persistence.*;

@Entity
@Table(name = "POI")
public class POI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lat;

    @Column(nullable = false)
    private String lon;

    @Column
    private String description;

    @Column(nullable = false)
    private Long user_id;

    @Column
    private String photo_url;

    public POI(){}

    //read
    public POI(Long id, String name, String lat, String lon, String description, Long user_id, String photo_url) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.user_id = user_id;
        this.photo_url = photo_url;
    }

    //create
    public POI(String name, String lat, String lon, String description, Long user_id, String photo_url) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.user_id = user_id;
        this.photo_url = photo_url;
    }

    //copy
    public POI(POI copy) {
        this.id = copy.id;
        name = copy.name;
        lat = copy.lat;
        lon = copy.lon;
        description = copy.description;
        user_id = copy.user_id;
        photo_url = copy.photo_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}

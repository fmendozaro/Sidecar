package live.jrmd.sidecar.models;

import javax.persistence.*;

@Entity
@Table(name = "poi_Comments")
public class POIComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long POI_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private String timestamp;

    public POIComment(){}
    //read
    public POIComment(Long id, Long POI_id, Long user_id, String comment, String timestamp) {
        this.id = id;
        this.POI_id = POI_id;
        this.user_id = user_id;
        this.comment = comment;
        this.timestamp = timestamp;
    }
    //create
    public POIComment(Long POI_id, Long user_id, String comment, String timestamp) {
        this.POI_id = POI_id;
        this.user_id = user_id;
        this.comment = comment;
        this.timestamp = timestamp;
    }
    //copy
    public POIComment(POIComment copy) {
        id = copy.id;
        POI_id = copy.POI_id;
        user_id = copy.user_id;
        comment = copy.comment;
        timestamp = copy.timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPOI_id() {
        return POI_id;
    }

    public void setPOI_id(Long POI_id) {
        this.POI_id = POI_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
}

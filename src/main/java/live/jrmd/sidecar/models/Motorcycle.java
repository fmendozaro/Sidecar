package live.jrmd.sidecar.models;

import javax.persistence.*;

@Entity
@Table(name = "motorcycles")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 4, nullable = false)
    private String year;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column
    private String photo_url;

    @Column(nullable = false)
    private String style;

    public Motorcycle(){}
    //read
    public Motorcycle(Long id, String year, String make, String model, String photo_url, String style) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.photo_url = photo_url;
        this.style = style;
    }
    //create
    public Motorcycle(String year, String make, String model, String photo_url, String style) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.photo_url = photo_url;
        this.style = style;
    }
    public Motorcycle (Motorcycle copy){
        this.id = copy.id;
        this.make = copy.make;
        this.model = copy.model;
        this.year = copy.year;
        this.style = copy.style;
        this.photo_url = copy.photo_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}

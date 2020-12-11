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


}

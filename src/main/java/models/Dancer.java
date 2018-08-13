package models;


import javax.persistence.*;

@Entity
@Table(name = "dancers")

public class Dancer {

    private int id;
    private String name;
    private String danceType;

    public Dancer(){}

    public Dancer(String name, String danceType) {
        this.name = name;
        this.danceType = danceType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "dance_type")
    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }
}

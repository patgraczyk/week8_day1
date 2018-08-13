package models;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "pointe_shoes")

public class Pointe {

    private int id;
    private String color;
    private int size;

    public Pointe(){}

    public Pointe(String color, int size) {
        this.color = color;
        this.size = size;
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

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

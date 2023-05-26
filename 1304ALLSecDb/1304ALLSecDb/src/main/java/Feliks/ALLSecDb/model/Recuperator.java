package Feliks.ALLSecDb.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Table
@Entity

public class Recuperator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;


    @OneToOne (mappedBy = "recuperator")
    private House house;

    public Recuperator(House house) {
        this.house = house;
    }

    public Recuperator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}

package Feliks.ALLSecDb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table (name = "Gates")

public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "gate_name")
    @NotBlank
    private String gateName;

    @Column (name = "gate_open")
    private boolean gateOpen;


    @ManyToOne
    private House house;

    public Gate(String gateName, boolean gateOpen, House house) {
        this.gateName = gateName;
        this.gateOpen = gateOpen;
        this.house = house;
    }

    public Gate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public boolean isGateOpen() {
        return gateOpen;
    }

    public void setGateOpen(boolean gateOpen) {
        this.gateOpen = gateOpen;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }


}

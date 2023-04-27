package Feliks.ALLSecDb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int room_id;

    @Column(name = "room_name")
    @NotBlank
    private String roomName;

    @Column(name = "co2_level_fact")
    private int co2LevelFact;

    @Column(name = "co2_level_min")
    private int co2LevelMin;

    @Column(name = "co2_level_max")
    private int co2LevelMax;

    @Column(name = "valves_are_open")
    private boolean valvesAreOpen;


    @ManyToOne @JoinTable(
            name = "house_room",
            joinColumns = @JoinColumn (name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private House house;


    public Room(String roomName, int co2LevelFact, int co2LevelMin, int co2LevelMax,
                boolean valvesAreOpen) {
        this.roomName = roomName;
        this.co2LevelFact = co2LevelFact;
        this.co2LevelMin = co2LevelMin;
        this.co2LevelMax = co2LevelMax;
        this.valvesAreOpen = valvesAreOpen;


    }

    public Room() {
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCo2LevelFact() {
        return co2LevelFact;
    }

    public void setCo2LevelFact(int co2LevelFact) {
        this.co2LevelFact = co2LevelFact;
    }

    public int getCo2LevelMin() {
        return co2LevelMin;
    }

    public void setCo2LevelMin(int co2LevelMin) {
        this.co2LevelMin = co2LevelMin;
    }

    public int getCo2LevelMax() {
        return co2LevelMax;
    }

    public void setCo2LevelMax(int co2LevelMax) {
        this.co2LevelMax = co2LevelMax;
    }

    public boolean isValvesAreOpen() {
        return valvesAreOpen;
    }

    public void setValvesAreOpen(boolean valvesAreOpen) {
        this.valvesAreOpen = valvesAreOpen;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", roomName='" + roomName + '\'' +
                ", co2LevelFact=" + co2LevelFact +
                ", co2LevelMin=" + co2LevelMin +
                ", co2LevelMax=" + co2LevelMax +
                ", valvesAreOpen=" + valvesAreOpen +

                '}';
    }
}

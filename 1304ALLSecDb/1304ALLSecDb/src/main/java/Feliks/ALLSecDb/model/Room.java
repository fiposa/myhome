package Feliks.ALLSecDb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component //без этой аннотации не создастся бин!!!!
@JsonIgnoreProperties (ignoreUnknown = true) //Чтоб не уходил в ошибку при появлении непонятных полей


@Table(name = "room")//можно не указывать, тогда будет дефолтное название
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "room_name")
    @NotBlank
    private String roomName;

    ///@JsonView(View.User.class) Можем скрыть видимость некоторых параметров для некоторых пользователей

    @Column(name = "co2_level_fact")
    private int co2LevelFact;

    @Column(name = "co2_level_min")
    private int co2LevelMin;

    @Column(name = "co2_level_max")
    private int co2LevelMax;

    @Column(name = "valves_are_open")
    private boolean valvesAreOpen;


    @ManyToOne (fetch = FetchType.LAZY)

    private Recuperator recuperator;

    public Room(String roomName, int co2LevelFact, int co2LevelMin, int co2LevelMax, boolean valvesAreOpen, Recuperator recuperator) {
        this.roomName = roomName;
        this.co2LevelFact = co2LevelFact;
        this.co2LevelMin = co2LevelMin;
        this.co2LevelMax = co2LevelMax;
        this.valvesAreOpen = valvesAreOpen;
        this.recuperator = recuperator;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Recuperator getRecuperator() {
        return recuperator;
    }

    public void setRecuperator(Recuperator recuperator) {
        this.recuperator = recuperator;
    }
}

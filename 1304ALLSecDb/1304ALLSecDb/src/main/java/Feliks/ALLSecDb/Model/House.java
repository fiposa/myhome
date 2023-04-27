package Feliks.ALLSecDb.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "house")
public class House {
    @Column(name = "house_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "house_name")
    @NotBlank
    private String houseName;

    @Column (name = "address")
    @NotBlank
    private String address;

    //@Column(name = "roomList")
    @OneToMany (mappedBy = "house")

    List<Room> roomList;

    public House() {
    }

    public House(String houseName, String address) {
        this.houseName = houseName;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouse_name(String houseName) {
        this.houseName = houseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", house_name='" + houseName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package Feliks.ALLSecDb.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "house")
@Component
public class House {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    //@NotBlank
    private String name;


    //@NotBlank
    @ManyToOne
    private User user;


    @Column (name = "address")
    //@NotBlank
    private String address;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "recuperator_id", referencedColumnName = "id")
    private Recuperator recuperator;

    @OneToMany (mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List <Gate> gates;

    public House() {
    }

    public House(String name, User user, String address, Recuperator recuperator, List<Gate> gates) {
        this.name = name;
        this.user = user;
        this.address = address;
        this.recuperator = recuperator;
        this.gates = gates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Recuperator getRecuperator() {
        return recuperator;
    }

    public void setRecuperator(Recuperator recuperator) {
        this.recuperator = recuperator;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", recuperator=" + recuperator +
                ", gates=" + gates +
                '}';
    }
}

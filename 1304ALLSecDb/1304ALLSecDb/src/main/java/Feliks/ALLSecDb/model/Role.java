package Feliks.ALLSecDb.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @NotBlank
    @Column (name = "role_name")
    private String roleName;

    @ManyToOne
    private User user;


}

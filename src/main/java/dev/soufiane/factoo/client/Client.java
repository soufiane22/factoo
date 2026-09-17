package dev.soufiane.factoo.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Le numéro de telephone est obligatoire")
    private String phone;

    @Column(unique = true, nullable = false)
    @Email(message = "Le format de l'email est invalide")
    private String email;

    private String ice;

    protected Client() {}

    public Client(String name, String phone, String email, String ice) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ice = ice;
    }

    public UUID getId() {
        return id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIce() {
        return ice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }
}
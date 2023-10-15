package com.Htmlgame.Htmlgame.Entity;


import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "web")
public class Web {

    //Define Values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "pass_word")
    private String password;

    //Create Two Types Of Constructor

    public Web() {
    }

    public Web(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //Define Getter & Setter  Method

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Define toString Method

    @Override
    public String toString() {
        return "Web{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

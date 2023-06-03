package com.connection.database.db.entity;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;

import java.util.Objects;

@Validated
@Entity
@Table(name = "person", schema = "public")
public class UserEntity {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id)
            && Objects.equals(password, that.password)
            && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "id=" + id +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}

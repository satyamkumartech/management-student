package entities;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
public class Admin {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "adminId")
    private int adminId;

    public Admin(String id, String username, String password, int adminId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adminId = adminId;
    }
}

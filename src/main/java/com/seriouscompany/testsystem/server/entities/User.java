package com.seriouscompany.testsystem.server.entities;

import com.seriouscompany.testsystem.server.utils.Encrypt;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll",    query = "SELECT user FROM User user"),
        @NamedQuery(name = "User.findById",   query = "SELECT user FROM User user where id = :id")
})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

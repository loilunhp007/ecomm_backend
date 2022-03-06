package com.Sell_Store.demo.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "passwd",nullable = false)
    private String password;
    @Column(name = "state",nullable = false)
    private int state;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "uid")
    private UserDetail userDetail;
    public Account(String email,String password){
        this.email=email;
        this.password=password;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
}

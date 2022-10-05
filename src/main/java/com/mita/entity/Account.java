package com.mita.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class Account {
    @Id
    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;
}
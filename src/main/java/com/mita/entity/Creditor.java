package com.mita.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Creditor")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class Creditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CreditorID", nullable = false)
    private Integer id;

    @Column(name = "Address")
    private String address;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "JobTitle")
    private String jobTitle;

    @Column(name = "LastName")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Username")
    private Account account;

}
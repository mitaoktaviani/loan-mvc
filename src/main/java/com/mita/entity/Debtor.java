package com.mita.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Debtor")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DebtorID", nullable = false)
    private Integer id;

    @Column(name = "Address")
    private String address;

    @Column(name = "Age")
    private Long age;

    @Column(name = "Company")
    private String company;

    @Column(name = "ContactNumber")
    private String contactNumber;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "IDCardNumber")
    private String iDCardNumber;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Professions")
    private String professions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Username")
    private Account account;

   }
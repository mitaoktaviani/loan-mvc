package com.mita.dto.debtor;

import lombok.*;

import java.security.SecureRandom;
import java.time.Period;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class RegisterDebtor {
    private int id;
    private String username;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String lastName;
    private String address;
    private Long age;
    private String company;
    private String contactNumber;
    private String gender;
    private String idCardNumber;
    private String profession;
}

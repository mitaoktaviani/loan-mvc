package com.mita.dto.creditor;

import com.mita.validation.Compare;
import com.mita.validation.UniqueUsername;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
@Compare(firstField = "password",secondField = "passwordConfirmation",message = "Password does not match")
public class InsertCreditorDTO {
    private Integer id;
    @NotBlank(message = "Username is required")
    @UniqueUsername(message = "Username already exist")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Password Confirmation is required")
    private String passwordConfirmation;
    @NotBlank(message = "First Name is required")
    private String firstName;
    private String lastName;
    private String address;
    private String jobTitle;
}

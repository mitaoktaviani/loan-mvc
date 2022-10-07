package com.mita.dto.creditor;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class CreditorDTO {
    private Integer id;
    private String fullName;
    private String username;
    private String address;
    private String jobTitle;
}

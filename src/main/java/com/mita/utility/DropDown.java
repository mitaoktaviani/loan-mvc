package com.mita.utility;


import lombok.*;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class DropDown {
    private String stringValue;

    private Integer integerValue;

    private String text;

    public DropDown(){}

    public DropDown(Integer integerValue, String text) {
        this.integerValue = integerValue;
        this.text = text;
    }

    public DropDown(String stringValue, String text) {
        this.stringValue = stringValue;
        this.text = text;
    }

}

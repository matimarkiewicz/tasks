package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    //private String toCc;
}

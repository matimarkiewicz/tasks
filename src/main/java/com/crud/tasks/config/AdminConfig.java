package com.crud.tasks.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminConfig {

    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.mail}")
    private String adminMail;
}

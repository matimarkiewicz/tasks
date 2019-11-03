package com.crud.tasks.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MailConfig {

    @Value("${mail.username}")
    private String mailUsername;

    @Value("${mail.password}")
    private String mailPass;

    @Value("${mail.message}")
    private String mailMessage;
}

package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailPrintTest {

    @Autowired
    MailConfig mailConfig;

    @Test
    public void printMailUserNameTest() {
        System.out.println("username: " + mailConfig.getMailUsername());
    }

    @Test
    public void printMailPassTest() {
        System.out.println("password: " + mailConfig.getMailPass());
    }

    @Test
    public void printMailMessageTest() {
        System.out.println("message: " + mailConfig.getMailMessage());
    }
}
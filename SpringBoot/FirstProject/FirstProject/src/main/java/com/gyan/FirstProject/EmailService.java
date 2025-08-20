package com.gyan.FirstProject;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService{

    @Override
    public String sendMessage() {
        return "Email Sent Successfully Thanks!";
    }
}

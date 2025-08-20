package com.gyan.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {

    @Autowired
    private MessageService messageService;

    public Notification() {
        System.out.println("Notification Constructor Called...");
    }

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyMessage(){
        System.out.println(messageService.sendMessage());
    }
}

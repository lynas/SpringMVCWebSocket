package com.lynas.controller;

import com.lynas.model.User;
import com.lynas.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by sazzad on 2/11/16
 */
@Controller
public class HomeController {

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreeterService greeting(User message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new GreeterService("Hello, " + message.getName() + "!");
    }

    @RequestMapping(value = "/simMessage")
    public String greeting() throws Exception {
        template.convertAndSend("/topic/greetings",
                new GreeterService("Hello, Other!"));
        return "sample";
    }
}

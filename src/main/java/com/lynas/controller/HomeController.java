package com.lynas.controller;

import com.lynas.model.User;
import com.lynas.service.GreeterService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by sazzad on 2/11/16
 */
@Controller
public class HomeController {

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

}

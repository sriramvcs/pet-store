package com.project.petstore.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sriramvcs on 2016-12-03.
 */
@RestController
public class EchoHelloWorldController {

    @RequestMapping(path = "/echo/{message}", method= RequestMethod.GET)
    public Message getEchoHelloWorld(@PathVariable String message) {
        return new Message(message);
    }

    @Data
    class Message {
        private String message;

        public Message(String val) {
            this.message = val;
        }

        public Message(){};
    }
}

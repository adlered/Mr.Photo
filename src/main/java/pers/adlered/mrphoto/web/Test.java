package pers.adlered.mrphoto.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }
}
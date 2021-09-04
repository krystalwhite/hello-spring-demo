package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody not used now because using template AND must add Model model
    public String helloWithQueryParam(@RequestParam String name, Model model) {
//        return "Hello, " + name + "!";
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

}

package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    Handles request at path /hello
//    with class addition, path is /hello/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, String!";
//    }

    //    Handles request at path /goodbye
//    after including the controller class mapping, now the URL lives at hello/goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goodbye() {
        return "Adios, String!";
    }

//    handles request of the form  /hello?name=LaunchCode
//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")  //allows both GET and POST to work
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "hello, " + name + "!";
    }

//    handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
//    @ResponseBody

    public String helloWithPathParam(@PathVariable String name) {
        return "hello, " + name + "!";
    }


//    with new class mapping, this now lives at /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello'>" +  //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method = 'post'>" +  //submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }


}

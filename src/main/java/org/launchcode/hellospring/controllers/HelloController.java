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
    public String goodbye() {
        return "Goodbye, String!";
    }

//    handles request of the form  /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})  //allows both GET and POST to work
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

//    handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


//    with new class mapping, this now lives at /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" +  //submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    //    with new class mapping, this now lives at /hello/formWithLanguage
    @GetMapping("formWithLanguage")
    public String helloFormWithLanguage() {
        return "<html>" +
                "<body>" +
                "<form action='hello'>" +  //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name ='language' id='language-select'>" +
                "<option value =''> Please select a language </option>" +
                "<option value ='english'> English </option>" +
                "<option value ='farsi'> Farsi </option>" +
                "<option value ='french'> French </option>" +
                "<option value ='german'> German </option>" +
                "<option value ='hindi'> Hindi </option>" +
                "<option value ='italian'> Italian </option>" +
                "<option value ='spanish'> Spanish </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithLanguage(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    public static String createMessage(String userName, String userLanguage) {
        String languageHello = "";
        if (userLanguage.equals("spanish")) {
            languageHello = "Hola, ";
        } else if (userLanguage.equals("italian")) {
            languageHello = "Ciao, ";
        } else if (userLanguage.equals("hindi")) {
            languageHello = "Namaste, ";
        } else if (userLanguage.equals("german")) {
            languageHello = "Guten tag, ";
        } else if (userLanguage.equals("french")) {
            languageHello = "Bonjour, ";
        } else if (userLanguage.equals("farsi")) {
            languageHello = "Salaam, ";
        } else if (userLanguage.equals("english")) {
            languageHello = "Hello, ";
        }
        languageHello += userName;
//        return languageHello;
        return prettify(languageHello);
    }

    public static String prettify(String text) {
        return "<html>" +
                "<body>" +
                "<font size='+5'>" +
                "<p style='color:#0394fc'>" +
                text +
                "</p>" +
                "</font>" +
                "</body>" +
                "</html>";
    }

}

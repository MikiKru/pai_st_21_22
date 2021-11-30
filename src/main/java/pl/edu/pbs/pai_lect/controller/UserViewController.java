package pl.edu.pbs.pai_lect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserViewController {
    @ResponseBody           // REST end-point
    @GetMapping("/")        // mapowanie żądania GET posiadający w ścieżce fragment /
    public String helloString(){
        return "hello Spring!";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}

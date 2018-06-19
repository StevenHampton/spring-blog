package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {


    @GetMapping("/add/{n1}/and/{n2}")
    public @ResponseBody String add(
            @PathVariable int n1,
            @PathVariable int n2
    ){
        return String.format("%d + %d = %d", n1, n2, n1 + n2);
    }

    @GetMapping("/subtract/{n1}/from/{n2}")
    public @ResponseBody String subtract(
            @PathVariable int n1,
            @PathVariable int n2
    ){
        return String.format("%d - %d = %d", n1, n2, n1 - n2);
    }

    @GetMapping("/multiply/{n1}/and/{n2}")
    public @ResponseBody String multiply(
            @PathVariable int n1,
            @PathVariable int n2
    ){
        return String.format("%d * %d = %d", n1, n2, n1 * n2);
    }

    @GetMapping("/divide/{n1}/by/{n2}")
    public @ResponseBody String divide(
            @PathVariable int n1,
            @PathVariable int n2
    ){
        return String.format("%d / %d = %d", n1, n2, n1 / n2);
    }
}

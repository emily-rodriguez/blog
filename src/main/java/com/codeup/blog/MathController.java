package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{n}/and/{i}")
    public @ResponseBody String add(
            @PathVariable int n,
            @PathVariable int i
    ){
       return String.format("%d + %d = %d", n, i, n+i);
    }

    @GetMapping("/subtract/{n}/from/{i}")
    public @ResponseBody String subtract(
            @PathVariable int n,
            @PathVariable int i
    ){
        return String.format("%d - %d = %d", i, n, i-n);
    }

    @GetMapping("/multiply/{n}/and/{i}")
    public @ResponseBody String multiply(
            @PathVariable int n,
            @PathVariable int i
    ) {
        return String.format("%d x %d = %d", n, i, n*i);
    }

    @GetMapping("/divide/{n}/by/{i}")
    public @ResponseBody String divide(
            @PathVariable int n,
            @PathVariable int i
    ) {
        return String.format("%d / %d = %d", n, i, n/i);
    }


}

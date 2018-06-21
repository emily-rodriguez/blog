package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String playGame(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String guess(@PathVariable int guess, Model model) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(6) + 1;
        boolean match = guess == randomNumber;

        model.addAttribute("guess", guess);
        model.addAttribute("roll", randomNumber);
        model.addAttribute("match", match);
        return "roll-dice";
    }
}

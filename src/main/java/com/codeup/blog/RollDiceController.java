package com.codeup.blog;

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
        model.addAttribute("guess", guess);
        Random rand = new Random();
        int randomNumber = rand.nextInt(6) + 1;
        model.addAttribute("roll", randomNumber);
        String correctMessage = "Hooray! Your guess was correct!";
        String wrongMessage = "Wrong guess! Try again!";
        if(guess == randomNumber){
            model.addAttribute("correct_guess", correctMessage);
        } else {
            model.addAttribute("wrong_guess", wrongMessage);
        }
        return "roll-dice";
    }
}

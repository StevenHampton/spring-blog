package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiceController {


    @GetMapping("/roll-dice/{n}")
    public String diceRoll(@PathVariable int n, Model model){
        model.addAttribute("userGuess", n);
        int roll = (int)(6 * Math.random())+ 1;
        model.addAttribute("diceRoll", roll);
        String outcome = "You have guessed wrong, better luck next time LOSER!";
        if (roll == n){
            outcome = "You have guessed Right, lucky guess won't happen again.";
        }
        model.addAttribute("rollGuess", outcome);
        return "rollOutcome";
    }

    @GetMapping("/roll-dice/")
    public String diceRoll(){
        return "rollDice";
    }
}

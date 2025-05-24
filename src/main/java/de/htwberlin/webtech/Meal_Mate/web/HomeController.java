package de.htwberlin.webtech.Meal_Mate.web;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView("Meal-Mate");
        modelAndView.addObject("message", "Welcome to Meal Mate!");
        return modelAndView;
    }
}




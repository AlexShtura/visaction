package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Continent;
import com.teachmeskills.visaction.model.Country;
import com.teachmeskills.visaction.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list-of-countries")
    public ModelAndView listOfCountries(ModelAndView modelAndView) {
        modelAndView.addObject("countries", countryService.findAllCountries());
        modelAndView.setViewName("country/list-of-countries");
        return modelAndView;
    }

    @GetMapping("/list-of-countries/new-country")
    public ModelAndView newCountry(ModelAndView modelAndView) {
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("continents", Continent.values());
        modelAndView.setViewName("country/new-country");
        return modelAndView;
    }

    @PostMapping("/save-country")
    public ModelAndView saveCountry(@ModelAttribute Country country, ModelAndView modelAndView) {
        Country countryFromDb = countryService.findCountryByName(country.getNameCountry());
        if (countryFromDb != null) {
            modelAndView.addObject("countryExistsMessage", "Sorry! This country already exists!");
            modelAndView.setViewName("country/new-country");
            return modelAndView;
        }
        countryService.saveCountry(country);
        //String countryCreateMessage = "Created country <b>" + country.getNameCountry() + "</b>.";
        //modelAndView.addObject("countryCreateMessage", countryCreateMessage);
        modelAndView.setViewName("redirect:/list-of-countries"); //при redirect не выводит сообщение или нет списка
        return modelAndView;
    }

    @GetMapping("/list-of-countries/edit-country/{id}")
    public ModelAndView editCountry(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView.addObject("country", countryService.findCountryById(id));
        modelAndView.addObject("continents", Continent.values());
        modelAndView.setViewName("country/edit-country");
        return modelAndView;
    }

    @PostMapping("/update-country")
    public RedirectView updateCountry(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute Country country){
        countryService.updateCountry(id, country);
        String message=(country.isActive()?"Updated ":"Deleted ")+" user <b>"+country.getNameCountry()+"</b>.";
        RedirectView redirectView=new RedirectView("/list-of-countries",true);
        redirectAttributes.addFlashAttribute("countryMessage", message);
        return redirectView;
    }

}

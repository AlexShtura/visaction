/*package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Visa;
import com.teachmeskills.visaction.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visa")
public class VisaController {

    private VisaService visaService;

    @Autowired
    public VisaController(VisaService visaService){
        this.visaService = visaService;
    }

    @GetMapping()
    public ModelAndView main(ModelAndView modelAndView) {
        Iterable<Visa> visas = visaService.findAll();

        modelAndView.addObject("visas", visas);
        modelAndView.setViewName("visas");

        return modelAndView;
    }

    @PostMapping()
    public ModelAndView add(@RequestParam String text, @RequestParam String tag, ModelAndView modelAndView) {
        Visa visa = new Visa(text, tag);

        visaService.save(visa);

        Iterable<Visa> visas = visaService.findAll();

        modelAndView.addObject("visas", visas);
        modelAndView.setViewName("visas");

        return modelAndView;
    }

    @PostMapping("/filter")
    public ModelAndView filter(@RequestParam String filter, ModelAndView modelAndView) {
        Iterable<Visa> visas;

        if (filter != null && !filter.isEmpty()) {
            visas = visaService.findByCriteria(filter,filter);
        } else {
            visas = visaService.findAll();
        }

        modelAndView.addObject("visas", visas);
        modelAndView.setViewName("visas");

        return modelAndView;
    }
}*/

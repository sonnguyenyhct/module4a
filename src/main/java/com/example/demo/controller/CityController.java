package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.cityService.ICityService;
import com.example.demo.service.countryService.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService iCountryService;
    @ModelAttribute("countrys")
    public Iterable<Country> countryList(){
        return iCountryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showFormCountry(){
        ModelAndView modelAndView = new ModelAndView("listCity");
        modelAndView.addObject("listCity",cityService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editCountry(){
        ModelAndView modelAndView = new ModelAndView("listCity");
        modelAndView.addObject("listCity",cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView deleteCountry(){
        ModelAndView modelAndView = new ModelAndView("listCity");
        modelAndView.addObject("listCity",cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreateCity(){
        ModelAndView modelAndView = new ModelAndView("createCity");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createCity(@ModelAttribute City city){
        cityService.save(city);
        return "redirect:/city/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEditCity(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("editCity");
        modelAndView.addObject("city",cityService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public String showFormEditCity(@ModelAttribute City city){
        cityService.save(city);
        return "redirect:/city/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        cityService.remove(id);
        return "redirect:/city/";
    }
    @GetMapping("/show/{id}")
    public ModelAndView showCity(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("showCity");
        modelAndView.addObject("city",cityService.findById(id).get());
        return modelAndView;
    }
}

package com.carbontec.logiparts.controllers;


import com.carbontec.logiparts.jpa.repositories.LocationRepository;
import com.carbontec.logiparts.services.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;

@Controller
public class LocationController {
    @Resource
    private LocationService locationService;

    @GetMapping("/locations")
    public String showAllLocations(WebRequest request, Model model) {

        model.addAttribute("locations", locationService.getAllLocations());
        return "locations";
    }
}

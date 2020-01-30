package com.carbontec.logiparts.controllers;


import com.carbontec.logiparts.dto.HistoryDto;
import com.carbontec.logiparts.dto.LocationDto;
import com.carbontec.logiparts.services.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class MovingAndHistoryController {
    @Resource
    private LocationService locationService;

    @GetMapping("/move")
    public String showAllLocations(WebRequest request, Model model) {
        HistoryDto historyDto = new HistoryDto();

        Collection<LocationDto> allLocations = locationService.getAllLocations();
        model.addAttribute("locations", allLocations);
        model.addAttribute("history", historyDto);

        return "move-part";
    }

    @GetMapping("/history")
    public String showHistory(WebRequest request, Model model) {

        return "history";
    }

}

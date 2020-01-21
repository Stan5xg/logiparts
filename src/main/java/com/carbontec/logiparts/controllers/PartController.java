package com.carbontec.logiparts.controllers;

import com.carbontec.logiparts.dto.PartTypeDto;
import com.carbontec.logiparts.dto.UserRegistrationDto;
import com.carbontec.logiparts.services.PartService;
import com.carbontec.logiparts.services.PartTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Controller
public class PartController {
    private final PartTypeService partTypeService;
    private final PartService partService;

    @GetMapping("/part-types")
    public String showAllPartTypes(WebRequest request, Model model) {
        model.addAttribute("partTypes", partTypeService.findAll());
        model.addAttribute("newPartType", new PartTypeDto());

        return "part-types";
    }

    //TODO try replace with path= and postmapping
    @RequestMapping(value = "/part-types", method = RequestMethod.POST)
    public RedirectView addPartType(@ModelAttribute("newPartType") PartTypeDto partTypeDto, WebRequest request) {
        partTypeService.add(partTypeDto);
        return  new RedirectView("/part-types");
    }

    @RequestMapping(value = "/part-types/delete", method = RequestMethod.POST)
    public RedirectView deletePart(@ModelAttribute("partType") PartTypeDto partTypeDto, WebRequest request) {

        Integer id = partTypeDto.getId();
        if (null != id) {
            partTypeService.remove(id);
        }

        return  new RedirectView("/part-types");
    }

    @GetMapping("/parts")
    public String showAllParts(WebRequest request, Model model) {

        List<PartTypeDto> allParts = partTypeService.findAll();

        model.addAttribute("parts", partTypeService.findAll());
//        model.addAttribute("newPartType", new PartTypeDto());

        return "part-types";
    }



}

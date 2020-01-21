package com.carbontec.logiparts.controllers;

import com.carbontec.logiparts.dto.PartTypeDto;
import com.carbontec.logiparts.dto.UserRegistrationDto;
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

    @GetMapping("/parts")
    public String showAllCarts(WebRequest request, Model model) {

        Iterable<PartTypeDto> partTypeDtos = partTypeService.findAll();
        List<PartTypeDto> typeDtos = StreamSupport.stream(partTypeDtos.spliterator(), false).collect(Collectors.toList());
        model.addAttribute("partTypes", typeDtos);
        model.addAttribute("newPartType", new PartTypeDto());

        return "parts";
    }

//    @RequestMapping(value = "/parts", method = RequestMethod.POST)
//    public ModelAndView addNewType(@ModelAttribute("partType") PartTypeDto partTypeDto, BindingResult result) {
////        System.out.println(id);
//        return null;
//    }

    //TODO try replace with path= and postmapping
    @RequestMapping(value = "/parts", method = RequestMethod.POST)
    public RedirectView addPart(@ModelAttribute("newPartType") PartTypeDto partTypeDto, WebRequest request) {
        partTypeService.add(partTypeDto);
        return  new RedirectView("/parts");
    }

    @RequestMapping(value = "/parts/delete", method = RequestMethod.POST)
    public RedirectView registerUserAccount(@ModelAttribute("partType") PartTypeDto partTypeDto, WebRequest request) {

        Integer id = partTypeDto.getId();
        if (null != id) {
            partTypeService.remove(id);
        }

        return  new RedirectView("/parts");
    }



}

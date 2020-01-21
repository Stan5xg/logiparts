package com.carbontec.logiparts.controllers;

import com.carbontec.logiparts.jpa.repositories.PartTypeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Resource
    private PartTypeRepository partsRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }
//
//    @GetMapping("/bootstrap")
//    public String bootstrapPage(Model model) {
//        return "bootstrap";
//    }
//
//    @GetMapping("/index")
//    public String getIndex(Model model) {
//        return "index";
//    }
//
//    @GetMapping("/index2")
//    public String getIndex2(Model model) {
//        return "indexold";
//    }
//
//    @GetMapping("/buttons")
//    public String getButtons(Model model) {
//        return "buttons";
//    }
//
    @GetMapping("/tables")
    public String getTables(Model model) {
        return "examples/tables";
    }

    @GetMapping("/cards")
    public String getCards(Model model) {
        return "examples/cards";
    }


//    @GetMapping("/parts")
//    public @ResponseBody Iterable<PartType>
//    testParts() {
//        PartType partType1 = new PartType();
//        partType1.setName("Root");
//        PartType partType2 = new PartType();
//        partType2.setName("part2");
//        PartType partType3 = new PartType();
//        partType3.setName("part3");
//        PartType partType4 = new PartType();
//        partType4.setName("part4");
//
//        partType2.getPartTypes().add(partType3);
//        partType2.getPartTypes().add(partType4);
//
//        partsRepository.save(partType4);
//        partsRepository.save(partType3);
//        partsRepository.save(partType2);
//        partsRepository.save(partType1);
//
//        return partsRepository.findAll();
//    }




//    @GetMapping("/register")
//    public String getIndex(Model model) {
//        return "index";
//    }


}

package com.springframe5.hwtpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/index", "/index.html"})
    public String ownerLists() {
        return "owners/index";
    }
}

package com.n2015942043.main.controller;

import com.n2015942043.main.repository.BasicRepository;
import com.n2015942043.main.repository.ProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasicController {
    private BasicRepository basicRepository;
    private ProfileRepository profileRepository;

    public BasicController(BasicRepository basicRepository, ProfileRepository profileRepository) {
        this.basicRepository = basicRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("basicList", basicRepository.findAll());
        model.addAttribute("profileList", profileRepository.findAll());
        return "index";
    }

    @GetMapping("/basic/{name}")
    public String readBasic(@PathVariable String name, Model model){
        model.addAttribute("basic", basicRepository.findBasicByName(name));
        return "bitem";
    }

    @GetMapping("/profile/{network}")
    public String readProfile(@PathVariable String network, Model model){
        model.addAttribute("profile", profileRepository.findProfileByNetwork(network));
        return "pitem";
    }
}

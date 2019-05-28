package com.n2015942043.main.controller;

import com.n2015942043.main.domain.Basic;
import com.n2015942043.main.domain.Profile;
import com.n2015942043.main.repository.BasicRepository;
import com.n2015942043.main.repository.ProfileRepository;
import com.n2015942043.main.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("basicList", boardService.findBasicAll());
        model.addAttribute("profileList", boardService.findProfileAll());
        return "index";
    }

    @GetMapping("/basic/{idx}")
    public String readBasic(@PathVariable Long idx, Model model){
        model.addAttribute("basic", boardService.findBasicByIdx(idx));
        return "bitem";
    }

    @GetMapping("/profile/{idx}")
    public String readProfile(@PathVariable Long idx, Model model){
        model.addAttribute("profile", boardService.findProfileByIdx(idx));
        return "pitem";
    }

    @GetMapping("/basic/new")
    public String basicForm(Basic basic){
        return "bnew";
    }

    @PostMapping("/basic/add")
    public String addBasic(Basic basic, Model model){
        Basic saveBasic = boardService.saveBasic(basic);

        model.addAttribute("basic", boardService.findBasicByIdx(saveBasic.getIdx()));
        return "bitem";
    }
    @GetMapping("/profile/new")
    public String profileForm(Profile profile){
        return "pnew";
    }

    @PostMapping("/profile/add")
    public String addProfile(Profile profile, Model model){
        profile.setCreateDat(LocalDateTime.now());
        Profile saveProfile = boardService.saveProfile(profile);

        model.addAttribute("profile", boardService.findProfileByIdx(saveProfile.getIdx()));
        return "pitem";
    }
}

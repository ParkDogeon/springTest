package org.koreait.controllers;

import jakarta.validation.Valid;
import org.koreait.Boards.BoardRequiredCheck;
import org.koreait.Boards.BoardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardWriteService service;

    @GetMapping("/write")
    public String write(Model model){
        BoardRequiredCheck boardRequiredCheck = new BoardRequiredCheck();
        model.addAttribute("boardRequiredCheck", boardRequiredCheck);

        return "board/write";
    }


    @PostMapping("/write")
    public String writePs(@Valid BoardRequiredCheck boardRequiredCheck, Errors errors){


        if(errors.hasErrors()){
            return "board/write";
        }

        service.write(boardRequiredCheck);

        return "redirect:/board/list";
    }
}

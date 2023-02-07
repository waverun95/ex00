package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private BoardService service;

//    @GetMapping("/list")
//    public void list(Model model){
//        log.info("list");
//        model.addAttribute("list",service.getList());
//    }
    @GetMapping("/list")
    public void list(Model model, Criteria cri){
        log.info("list");

        log.info(cri+">>>>>>>>>>>>>>>>>");
        log.info(new PageDTO(cri,123)+">>>>>>>>>>>>>>>>>>>");
        model.addAttribute("list",service.getList(cri));
        int total = service.getTotal(cri);
        log.info("getTotal"+ total);
        model.addAttribute("pageMaker", new PageDTO(cri,total));
    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr){
        service.register(board);
        log.info("register:" + board);
        rttr.addFlashAttribute("result",board.getBno());
        return "redirect:/board/list";
    }
    @GetMapping("/register")
    public void register(){

    }
    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri){
        log.info("/get or modify");
        model.addAttribute("board",service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri){
        log.info("modify" + board);

        if (service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri){
        log.info("remove"+bno);
        if(service.remove(bno)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        return "redirect:/board/list";
    }

}

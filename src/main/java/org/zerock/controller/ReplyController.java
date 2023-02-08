package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import java.util.List;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    private ReplyService service;

    @PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO vo){
        log.info("ReplyVO= " +vo);
        int insertCount = service.register(vo);
        log.info("Reply Insert Count = " + insertCount);

        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping(value = "/pages/{bno}/{page}",produces = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<ReplyVO>> getListResponseEntity(@PathVariable("page") int page, @PathVariable("bno") Long bno){
        log.info("getList.......");
        Criteria cri = new Criteria(page,10);
        log.info(cri);

        return new ResponseEntity<>(service.getList(cri,bno),HttpStatus.OK);
    }
}

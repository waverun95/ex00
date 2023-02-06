package org.zerock.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
    @Autowired
    BoardService boardService;

    BoardVO vo = new BoardVO();
    @Test
    public void insert (){
        vo.setTitle("service title");
        vo.setContent("service content");
        vo.setWriter("service writer");
        boardService.register(vo);
        log.info(vo);
    }
    @Test
    public void read(){
        boardService.get(4L);
    }
    @Test
    public void delete(){
        log.info(boardService.remove(8L)+"asdsadsadsadsadas");
    }
    @Test
    public void update(){
        vo.setBno(5L);
        vo.setTitle("updagte title");
        vo.setContent("update content");
        vo.setWriter("update writer");
        boardService.modify(vo);
        log.info(vo);
    }
    @Test
    public void getList(){
        boardService.getList().forEach(board -> log.info(board));
    }
}

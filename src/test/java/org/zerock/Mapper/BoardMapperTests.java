package org.zerock.Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.TimeMapper;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    @Test
    public void getList(){

        boardMapper.getList().forEach(board -> {
            log.info(board);
        });

    }
    @Test
    public void getListWithPaging(){

//        Criteria cri = new Criteria(1,1);
//        cri.setPageNum(3);
//        cri.setAmount(10);
//        log.info(cri+"111111111111111111111111111");
//        boardMapper.getListWithPaging(cri).forEach(board -> {
//            log.info(board);
//        });

    }
    @Test
    public void insert(){
        BoardVO vo = new BoardVO();
        vo.setTitle("새로운글");
        vo.setContent("새로 작성하는 내용");
        vo.setWriter("newbie");
        boardMapper.insertSelectKey(vo);
        log.info(vo);
    }
    @Test
    public void read(){
        BoardVO vo = new BoardVO();
        vo = boardMapper.read(5L);
        log.info(vo+"dsadsadsadsadasdsa");
    }
    @Test
    public void delete(){
       int a =  boardMapper.delete(3L);
        log.info(a+"delete count.';;;;;;;;;;;");
    }
    @Test
    public void update(){
        BoardVO vo = new BoardVO();
        vo.setBno(4L);
        vo.setTitle("수정된 제목");
        vo.setContent("수정된 내용");
        vo.setWriter("수정된 작성자");
        int a = boardMapper.update(vo);
        log.info(a+"dsadsadsadsad");
    }
}

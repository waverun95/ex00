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
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
    @Setter(onMethod_ = {@Autowired})
    private ReplyMapper replyMapper;

   @Test
    public void testMapper(){
       log.info(replyMapper);
   }
   @Test
    public void testinsert(){
       ReplyVO vo = new ReplyVO();
       vo.setBno(1L);
       vo.setReply("댓글테스트");
       vo.setReplyer("replyer");
       replyMapper.insert(vo);
   }
   @Test
    public void testRead(){
       Long targetgRno = 1L;
       ReplyVO vo = replyMapper.read(targetgRno);

       log.info(vo);
   }
    @Test
    public void testDelete(){
        Long targetgRno = 2L;
        int num =  replyMapper.delete(targetgRno);

        log.info(num);
    }
    @Test
    public void testUpdate(){
       Long targetRno = 1L;
       ReplyVO vo = replyMapper.read(targetRno);
       vo.setReply("Update Reply");
       int count = replyMapper.update(vo);
       log.info("Update Count: " + count);
    }

    @Test
    public void testList(){
       Criteria cri = new Criteria();
        List<ReplyVO> replies = replyMapper.getListWithPaging(cri,1L);
        replies.forEach(reply->log.info(reply));
    }
}

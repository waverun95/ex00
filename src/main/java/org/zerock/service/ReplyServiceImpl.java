package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import java.util.List;

@Service
@Log4j

public class ReplyServiceImpl implements ReplyService{
    @Setter(onMethod_= @Autowired)
    private ReplyMapper replyMapper;
    @Override
    public int register(ReplyVO vo) {
        return replyMapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long bno) {
        return replyMapper.read(bno);
    }

    @Override
    public int modify(ReplyVO vo) {
        return replyMapper.update(vo);
    }

    @Override
    public int remove(Long rno) {
        return replyMapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        return replyMapper.getListWithPaging(cri,bno);
    }


    @Override
    public ReplyPageDTO getListPage(Criteria cri, Long bno) {
        return new ReplyPageDTO(replyMapper.getCountByBno(bno),replyMapper.getListWithPaging(cri,bno));
    }

    @Override
    public int getTotal(Long bno) {
        return replyMapper.getCountByBno(bno);
    }
}

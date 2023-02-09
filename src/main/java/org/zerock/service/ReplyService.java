package org.zerock.service;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyService {
    public int register(ReplyVO vo);
    public ReplyVO get(Long bno);
    public int modify(ReplyVO vo);
    public int remove(Long rno);
//    public List<BoardVO> getList();
    public List<ReplyVO> getList(Criteria cri,Long bno);

    public ReplyPageDTO getListPage(Criteria cri,Long bno);
    public int getTotal(Long bno);

}

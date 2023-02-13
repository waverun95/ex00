package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import java.util.List;
@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardMapper boardMapper;
    private BoardAttachMapper attachMapper;
    @Transactional
    @Override
    public void register(BoardVO vo) {

        log.info("register..." + vo);
        boardMapper.insertSelectKey(vo);

        if(vo.getAttachList() == null || vo.getAttachList().size() <= 0) {
            return;
        }
        vo.getAttachList().forEach(attach -> {
            attach.setBno(vo.getBno());
            attachMapper.insert(attach);
        });
    }

    @Override
    public BoardVO get(Long bno) {
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO vo) {

        return boardMapper.update(vo) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        return boardMapper.delete(bno) == 1;
    }

//    @Override
//    public List<BoardVO> getList() {
//        return boardMapper.getList();
//    }

    @Override
    public List<BoardVO> getList(Criteria cri) {

        log.info(cri+"........................");
        return boardMapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        return boardMapper.getTotalCount(cri);
    }

    @Override
    public List<BoardAttachVO> getAttachList(Long bno) {
        return attachMapper.findByBno(bno);
    }
}

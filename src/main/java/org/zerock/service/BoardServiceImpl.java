package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import java.util.List;
@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardMapper boardMapper;
    @Override
    public void register(BoardVO vo) {
        boardMapper.insertSelectKey(vo);
    }

    @Override
    public BoardVO get(Long bno) {
        return boardMapper.read(bno);
    }

    @Override
    public boolean update(BoardVO vo) {

        return boardMapper.update(vo) == 1;
    }

    @Override
    public boolean delete(Long bno) {
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }
}

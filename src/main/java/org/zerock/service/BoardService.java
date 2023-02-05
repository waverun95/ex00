package org.zerock.service;

import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public void register(BoardVO vo);
    public BoardVO get(Long bno);
    public boolean update(BoardVO vo);
    public boolean delete(Long bno);
    public List<BoardVO> getList();
}

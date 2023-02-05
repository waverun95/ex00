package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    //@Select("select * from tbl_board")
    public List<BoardVO> getList();
    public void insert(BoardVO vo);
    public void insertSelectKey(BoardVO vo);
    public BoardVO read(Long bno);
    public int delete(Long bno);
    public int update(BoardVO vo);

}

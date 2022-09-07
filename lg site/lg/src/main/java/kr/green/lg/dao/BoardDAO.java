package kr.green.lg.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(BoardVO board);

	ArrayList<BoardVO> selectBoard(@Param("cri")Criteria cri, @Param("bd_type")String bd_type);

	int selectBoardTotalCount(@Param("cri")Criteria cri, @Param("bd_type")String bd_type);

	BoardVO selectBoard(Integer bd_num);

	int deleteBoard(Integer bd_num);

}

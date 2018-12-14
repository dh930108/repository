package com.kosmo.test0903;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardService {
	ArrayList<BoardVO> boardList();
	int boardInsert(BoardVO bvo);
	int replyInsert(BoardReplyVO brvo);
	HashMap<String, Object> boardView(int bseq);

}

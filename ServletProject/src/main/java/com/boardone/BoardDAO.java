package com.boardone;

public class BoardDAO {
	private static BoardDAO instance = null;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	//게시판 작업을 하나하나 메소드로 작성해서 추가하면 됨.
	
	
}

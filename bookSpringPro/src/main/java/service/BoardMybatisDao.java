package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import model.Board;
import util.MybatisConnection;


@Component
public class BoardMybatisDao {
		private static final String ns="board.";
		private Map<String, Object> map = new HashMap<String, Object>();
		
		//Board 테이블에 검색된 단어가 포함된 도서관이 있으면 찾아서 리스트로 저장
		public List<Board> list1(String req1,int pageInt, int limit,String boardid) { // limit =3
			SqlSession session = MybatisConnection.getConnection();
					
			int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
		
			try {
				map.clear();
				map.put("boardid", boardid);
				map.put("keyword", req1);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"list1",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
				MybatisConnection.close(session);		
			}		
			return null;	
		}

		//Board 테이블에 검색된 단어가 포함된 도서관이 있으면 해당 개수를 찾음
		public int boardCount1(String req1,String boardid) {
			SqlSession session = MybatisConnection.getConnection();
			map.clear();
			map.put("keyword", req1);
			map.put("boardid", boardid);
			try {
				return session.selectOne(ns + "boardCount1", map);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}
		
		//Board 테이블에 검색된 단어가 포함된 작성자가 있으면 찾아서 리스트로 저장
		public List<Board> list2(String req2,int pageInt, int limit, String boardid) { // limit =3
			SqlSession session = MybatisConnection.getConnection();
					
			int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
					
			try {
				map.clear();
				map.put("keyword", req2);
				map.put("boardid", boardid);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"list2",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
				MybatisConnection.close(session);		
			}		
			return null;	
		}
		
		//Board 테이블에 검색된 단어가 포함된 작성자가 있으면 해당 개수를 찾음
		public int boardCount2(String req2,String boardid) {
			SqlSession session = MybatisConnection.getConnection();
			map.clear();
			map.put("keyword", req2);
			map.put("boardid", boardid);
			try {
				return session.selectOne(ns + "boardCount2", map);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}

		//Board 테이블에 검색된 단어가 포함된 도서관과 작성자가 있으면 찾아서 리스트로 저장
		public List<Board> list3(String req1,String req2,int pageInt,int limit,String boardid) { // limit =3
			SqlSession session = MybatisConnection.getConnection();
					
			int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
					
			try {
				map.clear();
				map.put("keyword1", req1);
				map.put("keyword2", req2);
				map.put("boardid", boardid);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"list3",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
				MybatisConnection.close(session);		
			}		
			return null;	
		}
	
		//Board 테이블에 검색된 단어가 포함된 도서관과 작성자가 있으면 해당 개수를 찾음
		public int boardCount3(String req1,String req2,String boardid) {
			SqlSession session = MybatisConnection.getConnection();
			map.put("keyword1", req1);
			map.put("keyword2", req2);
			map.put("boardid", boardid);
			try {
				return session.selectOne(ns + "boardCount3", map);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}

		//작성한 게시물이 Board테이블에 성공적으로 삽입되었는지 여부 확인
		public boolean insert(Board board) {
			SqlSession session = MybatisConnection.getConnection();
					
			int ref = 0, reflevel = 0, refstep = 0;
					
			try {		
				//게시물 번호는 시퀀스로 하여 삽입
				int num = session.selectOne(ns +"seqNextval");
				//답글일경우
				if (board.getNum() > 0) {
					ref = board.getRef();
					reflevel = board.getReflevel() + 1;
					refstep = board.getRefstep() + 1;
				} else {
					ref = num;
				}
				board.setNum(num);
				board.setRef(ref);
				board.setReflevel(reflevel);
				board.setRefstep(refstep);	
				session.insert(ns+"insertBoard",board);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return false;
		}

		// 해당 게시물번호를 가진 게시물 조회
		public Board selectOne(int num) {
			SqlSession session = MybatisConnection.getConnection();
				
			try {
				return session.selectOne(ns+"selectOne", num);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);		
			}
			return null;	
		}
	
		//조회건수 증가 조회수+1로 변경
		public void readcntadd(int num) {
			SqlSession session = MybatisConnection.getConnection();
				
			try {
				session.update(ns+"readcntadd",num);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
		}
		
		//게시물 수정 내용 Board테이블에 성공적으로 update되었는지 여부 확인
		public boolean update(Board board) {
			SqlSession session = MybatisConnection.getConnection();
			try {
				session.update(ns+"update",board);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return false;
		}
		
		//Board테이블에서 해당 게시물 번호가 성공적으로 delete되었는지 여부 확인
		public boolean delete(int num) {
			SqlSession session = MybatisConnection.getConnection();
			try {
				session.delete(ns+"delete", num);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return false;
		}
			
		//답글 추가 되면 refstep+1
		public void refstepadd(int ref, int refstep) {
			SqlSession session = MybatisConnection.getConnection();
				
			try {
				map.clear();
				map.put("ref", ref);
				map.put("refstep", refstep);
				session.update(ns+"refstepadd",map);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
		}
	
}//end
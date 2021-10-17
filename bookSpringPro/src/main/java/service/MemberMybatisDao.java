package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import model.Member;
import util.MybatisConnection;


@Component
public class MemberMybatisDao {
	
		private static final String ns = "member.";
		private Map<String, Object> map = new HashMap<String, Object>();
			
		//Member테이블에 회원정보 삽입(1이면 삽입 성공)
		public int memberInsert(Member member) {
			SqlSession session = MybatisConnection.getConnection();
				
			try {
				session.insert(ns + "memberInsert", member);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}
		
		//해당 memberid(회원 아이디)가 있는 데이터 조회
		public Member selectOne(String memberid) {
			SqlSession session = MybatisConnection.getConnection();
		        
			try {
				return session.selectOne(ns+"selectOne",memberid);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);		
			}
			return null;
		}
			
		//검색된 회원아이디(req)가 포함된 데이터를 리스트로 저장
		public List<Member> memberList(String req,int pageInt,int limit,int membercount) {
			SqlSession session = MybatisConnection.getConnection();
			 		
			int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
		
			try {
				map.clear();
				map.put("keyword", req);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"memberList",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
				MybatisConnection.close(session);		
			}		
			return null;	
		}
		
		//검색된 회원아이디(req)가 포함된 데이터 개수 출력
		public int memberCount(String req) {
			SqlSession session = MybatisConnection.getConnection();
					
			try {
				return session.selectOne(ns + "memberCount",req);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}
		     
		//수정된 회원 정보 Member테이블에 update되었는지 여부확인 (1이면 update성공)
		public int  memberUpdate(Member member) {
			SqlSession session = MybatisConnection.getConnection();
		 		
			try {
				session.update(ns+"memberUpdate",member);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}
		     
		//해당 id와 비밀번호가 맞는 데이터 Member테이블에서 삭제
		public int  memberDelete(String id, String pass) {
			SqlSession session = MybatisConnection.getConnection();
			map.put("memberid", id);
			map.put("pass", pass);
				
			try {
				int cnt = session.update(ns+"memberDelete",map);
				return cnt;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}
		     
		//Member테이블에 해당 아이디가 있는지 개수확인(1이면 해당 아이디가 이미 있으므로 사용 못함)
		public int idChk(String memberid) {
			SqlSession session = MybatisConnection.getConnection();
			
			try {
				return session.selectOne(ns+"idChk",memberid);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MybatisConnection.close(session);
			}
			return 0;
		}

}//end
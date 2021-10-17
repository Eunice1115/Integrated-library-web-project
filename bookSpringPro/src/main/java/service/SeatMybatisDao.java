package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import model.Seat;
import util.MybatisConnection;

@Component
public class SeatMybatisDao {
	private static final String ns = "seat.";
	private Map<String, Object> map = new HashMap<String, Object>();

	//입실하면 Seat테이블에 정보 삽입(1이면 입실 성공)
	public int seatInsert(Seat seat) {
		SqlSession session = MybatisConnection.getConnection();
	
		try {
			return session.insert(ns + "seatInsert", seat);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	//id와 비밀번호가 입실했을 때와 같으면 update
	public int seatUpdate(String memberid, String pass) {
		SqlSession session = MybatisConnection.getConnection();
	
		try {
			map.clear();
			map.put("memberid", memberid);
			map.put("pass", pass);
			session.update(ns + "seatUpdate", map);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	//입실했을 때의 아이디와 비밀번호가 같으면 퇴실처리됨(num이 1이면 delete)
	public int seatDelete(String id, String pass) {
		SqlSession session = MybatisConnection.getConnection();

		try {
			map.clear();
			map.put("memberid", id);
			map.put("pass", pass);
			session.delete(ns + "seatDelete", map);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}
	
	//해당 아이디가 있는 데이터를 Seat테이블에서 찾는다.
	public Seat selectOne(String memberid) {
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
	
	//해당 아이디가 있는 데이터를 Seat테이블에서 리스트로 찾는다.
	public List<Seat> Selectlist(String memberid){
		SqlSession session = MybatisConnection.getConnection();
	 		
		try {
			return session.selectList(ns + "selectOne",memberid);
		} catch (Exception e) {			
			e.printStackTrace();		
		} finally {
			MybatisConnection.close(session);		
		}		
		return null;	
	}
	

}//end
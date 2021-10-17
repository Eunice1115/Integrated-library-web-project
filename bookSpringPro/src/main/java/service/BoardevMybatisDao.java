package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import model.Board;
import model.Boardev;
import model.Book;
import model.Bookreserve;
import model.Eventrsv;
import util.MybatisConnection;

@Component
public class BoardevMybatisDao {
	 private static final String ns="boardev.";
     private Map<String, Object> map = new HashMap<String, Object>();
     
     //Board_event 테이블에 검색된 단어가 포함된 도서관이 있으면 찾아서 리스트로 저장
     public List<Boardev> evList1(String req1,int pageInt,int limit,int evcount,String boardid_ev) {
    	    SqlSession session = MybatisConnection.getConnection();
			
			int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
			
			try {
				map.clear();
				map.put("boardid_ev", boardid_ev);
				map.put("keyword", req1);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"evList1",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
			    MybatisConnection.close(session);		
		    }		
			return null;	
		}
      
      //Board_event 테이블에 검색된 단어가 포함된 도서관이 있으면 해당 개수를 찾음
      public int evCount1(String req1, String boardid_ev) {
 			SqlSession session = MybatisConnection.getConnection();
 			map.put("keyword",req1);
 	      	map.put("boardid_ev",boardid_ev);
 			try {
 				return session.selectOne(ns + "evCount1",map);
 			} catch (Exception e) {
 				e.printStackTrace();
 			} finally {
 				MybatisConnection.close(session);
 			}
 			return 0;
 		}
      
      //Board_event 테이블에 검색된 단어가 포함된 대상이 있으면 찾아서 리스트로 저장
      public List<Boardev> evList2(String req2,int pageInt,int limit,int evcount,String boardid_ev) {
    	    SqlSession session = MybatisConnection.getConnection();
			
    	    int start = (pageInt - 1) * limit + 1;  //시작 번호
			int end = start + limit - 1;  //end 번호
			
			try {
				map.clear();
				map.put("boardid_ev", boardid_ev);
				map.put("keyword", req2);
				map.put("start", start);
				map.put("end", end);
				return session.selectList(ns+"evList2",map);
			} catch (Exception e) {			
				e.printStackTrace();		
			} finally {
			    MybatisConnection.close(session);		
		    }		
			return null;	
		}
      
        //Board_event 테이블에 검색된 단어가 포함된 대상이 있으면 해당 개수를 찾음
        public int evCount2(String req2,String boardid_ev) {
   			SqlSession session = MybatisConnection.getConnection();
   			map.put("keyword",req2);
 	      	map.put("boardid_ev",boardid_ev);
   			try {
   				return session.selectOne(ns + "evCount2",map);
   			} catch (Exception e) {
   				e.printStackTrace();
   			} finally {
   				MybatisConnection.close(session);
   			}
   			return 0;
   		}
        
        //Board_event 테이블에 검색된 단어가 포함된 도서관과 대상이 있으면 찾아서 리스트로 저장
        public List<Boardev> evList3(String req1,String req2,int pageInt,int limit,int evcount,String boardid_ev) {
            SqlSession session = MybatisConnection.getConnection();
 			
 			int start = (pageInt - 1) * limit + 1;  //시작 번호
 			int end = start + limit - 1;  //end 번호
 			
 			try {
 				map.clear();
 				map.put("keyword1", req1);
 				map.put("keyword2", req2);
 				map.put("boardid_ev", boardid_ev);
 				map.put("start", start);
 				map.put("end", end);
 				return session.selectList(ns+"evList3",map);
 			} catch (Exception e) {			
 				e.printStackTrace();		
 			} finally {
 			    MybatisConnection.close(session);		
 		    }		
 			return null;	
 		}
        
        //Board_event 테이블에 검색된 단어가 포함된 도서관과 대상이 있으면 해당 개수를 찾음
        public int evCount3(String req1,String req2,String boardid_ev) {
   			SqlSession session = MybatisConnection.getConnection();
   			map.put("keyword1",req1);
        	map.put("keyword2",req2);
        	map.put("boardid_ev",boardid_ev);
   			try {
   				return session.selectOne(ns + "evCount3",map);
   			} catch (Exception e) {
   				e.printStackTrace();
   			} finally {
   				MybatisConnection.close(session);
   			}
   			return 0;
   		}
	
        //이벤트 내용을 Board_event테이블에 삽입
        public int boardevInsert(Boardev boardev) {
       		SqlSession session = MybatisConnection.getConnection();
       		
       		try {
       			int num = session.selectOne(ns +"eventseqNextval"); //이벤트 넘버를 시퀀스로 만들어 추가
       			boardev.setEventnum(num);
       			
       			session.insert(ns + "boardevInsert", boardev);
       			return 1;
       		} catch (Exception e) {
       			// TODO Auto-generated catch block
       			e.printStackTrace();
       		} finally {
       			MybatisConnection.close(session);
       		}
       		return 0;
       	}
        
        //해당 eventnum(이벤트 넘버)와 boardid_ev가 포함된 자료를 테이블에서 찾음
        public Boardev selectBoardev(int eventnum,String boardid_ev) {
     		SqlSession session = MybatisConnection.getConnection();
     		
     		map.put("eventnum",eventnum);
     		map.put("boardid_ev",boardid_ev);
     		try {
     			return session.selectOne(ns+"selectBoardev", map);
     		} catch (Exception e) {
     			e.printStackTrace();
     		} finally {
     			MybatisConnection.close(session);		
     		}
     		return null;
     	}
        
        //해당 eventnum(이벤트 넘버)가 있는 자료를 테이블에서 찾아서 리스트로 저장
        public List<Eventrsv> chkList(int eventnum) {
        	SqlSession session = MybatisConnection.getConnection();
        	 		
     		try {
    			return session.selectList(ns + "chkList",eventnum);
    		} catch (Exception e) {			
    			e.printStackTrace();		
    		} finally {
    		    MybatisConnection.close(session);		
    	    }		
    		return null;	
    	}
        
        //해당 eventnum(이벤트 넘버)가 있는 자료를 테이블에서 찾음 
        public Boardev selectOne(int eventnum) {
     		SqlSession session = MybatisConnection.getConnection();
     		
     		try {
     			return session.selectOne(ns+"selectOne", eventnum);
     		} catch (Exception e) {
     			e.printStackTrace();
     		} finally {
     			MybatisConnection.close(session);		
     		}
     		return null;	
     	}

        //수정된 이벤트가 Board_event테이블에 제대로 update되었는지 확인
        public boolean update(Boardev boardev) {
    		SqlSession session = MybatisConnection.getConnection();
    		try {
    			session.update(ns+"update",boardev);
    			return true;
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			MybatisConnection.close(session);
    		}
    		return false;
    	}
        
        //해당 eventnum(이벤트 넘버)를 가진 자료가 Board_event테이블에서 제대로 delete되었는지 확인
        public boolean delete(int eventnum) {
    		SqlSession session = MybatisConnection.getConnection();
    		try {
    			session.delete(ns+"delete", eventnum);
    			return true;
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			MybatisConnection.close(session);
    		}
    		return false;
    	}
        
        //해당 eventnum(이벤트 넘버)와 memberid(회원아이디)가 Eventrsv(이벤트 예약 테이블)에 있는지 개수 출력
        public int preEvreserve(int eventnum, String memberid) {
        	SqlSession session = MybatisConnection.getConnection();
        	map.put("eventnum",eventnum);
        	map.put("memberid",memberid);
        	try {
        		int num = session.selectOne(ns+"preEvreserve",map);
        		return num;
        	}catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			MybatisConnection.close(session);
    		}
    		return 0;
        }
        
        //등록한 이벤트 정보를 Eventrsv테이블에 삽입(삽입 성공시 1)
        public int insertEvreserve(Eventrsv eventrsv) {
        	SqlSession session = MybatisConnection.getConnection();
        	
        	try {
        		int num = session.selectOne(ns +"eventrsvseqNextval");
        		eventrsv.setRsvnum_ev(num);
        		session.insert(ns + "insertEvreserve", eventrsv);
       			return 1;
        		
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			MybatisConnection.close(session);
    		}
    		return 0;
        }
        
        
        //Eventrsv 삽입 성공하면 해당 eventnum(이벤트 넘버)를 가진 데이터는 등록인원이 +1 된다.
        public void rsvstateUpdate(int eventnum) {
        	SqlSession session = MybatisConnection.getConnection();
        	
        	try {
        		session.update(ns+"rsvstateUpdate",eventnum);
        	} catch (Exception e) {
       			e.printStackTrace();
       		} finally {
       			MybatisConnection.close(session);
       		}
        }
        
       /* 
        *등록인원이 정원과 같아지면 해당 eventnum(이벤트 넘버)를 가진 데이터는 자동으로 접수종료가 된다.
        *반대로 이벤트를 취소하여 등록인원이 정원에 미달하면 자동으로 접수중이 된다.
        */
        public void fullUpdate(int eventnum,String state) {
        	SqlSession session = MybatisConnection.getConnection();
        	map.put("keyword", state);
        	map.put("eventnum",eventnum);
        	
        	try {
        		session.update(ns+"fullUpdate",map);
        	}catch(Exception e) {
        		e.printStackTrace();
       		} finally {
       			MybatisConnection.close(session);
       		}
        }
        
        
        //해당 memberid(회원 아이디)를 가진 사람이 등록한 이벤트 내역을 리스트로 찾는다.
        public List<Eventrsv> evRsvlist(String memberid) {
        	SqlSession session = MybatisConnection.getConnection();
        	 		
     		try {
    			return session.selectList(ns + "evRsvlist",memberid);
    				
    		} catch (Exception e) {			
    			e.printStackTrace();		
    		} finally {
    		    MybatisConnection.close(session);		
    	    }		
    		return null;	
    	}
        
        //해당 eventnum(이벤트 넘버)와 memberid(회원 아이디)를 가진 데이터를 Eventrsv테이블에서 삭제
        public int evReserveDelete(int eventnum, String memberid) {
        	SqlSession session = MybatisConnection.getConnection();
        	map.put("eventnum", eventnum);
        	map.put("memberid", memberid);
    		try {
    			int num = session.delete(ns+"evReserveDelete", map);
    			return num;
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			MybatisConnection.close(session);
    		}
    		return 0;
    	}
    	
        //Eventrsv 삭제 성공하면 해당 eventnum(이벤트 넘버)를 가진 데이터는 등록인원이 -1 된다.
        public void rsvstateUpdate2(int eventnum) {
           SqlSession session = MybatisConnection.getConnection();
        	
        	try {
        		session.update(ns+"rsvstateUpdate2",eventnum);
        	} catch (Exception e) {
       			e.printStackTrace();
       		} finally {
       			MybatisConnection.close(session);
       		}
        }
        
        
}//end

package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import model.Bestbook;
import model.Board;
import model.Book;
import model.Bookreserve;
import model.Join;
import model.Member;
import model.Rental;
import util.MybatisConnection;


@Component
public class BookMybatisDao {
	 private static final String ns="book.";
     private Map<String, Object> map = new HashMap<String, Object>();
     
     //Book 테이블에 검색된 단어가 없으면 전부 리스트로 저장
     public List<Book> bookList(int pageInt, int limit, int bookcount) {
    	 SqlSession session = MybatisConnection.getConnection();
   		 		
    	 int start = (pageInt - 1) * limit + 1;  //시작 번호
    	 int end = start + limit - 1;  //end 번호
 		
    	 try {
    		 map.clear();
    		 map.put("start", start);
    		 map.put("end", end);
    		 return session.selectList(ns+"bookList",map);
    	 } catch (Exception e) {			
    		 e.printStackTrace();		
    	 } finally {
    		 MybatisConnection.close(session);		
    	 }		
 		return null;	
 	 }
     
     //Book 테이블에 검색된 단어가 없으면 모든 개수 count
     public int bookCount() {
    	 SqlSession session = MybatisConnection.getConnection();
			
    	 try {
    		 return session.selectOne(ns + "bookCount");
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 } finally {
    		 MybatisConnection.close(session);
    	 }
    	 return 0;
	 }
     
     //Book 테이블에 검색된 단어가 포함된 도서관이 있으면 찾아서 리스트로 저장
     public List<Book> bookList1(String req1,int pageInt, int limit, int bookcount) {
    	 SqlSession session = MybatisConnection.getConnection();
  		 		
    	 int start = (pageInt - 1) * limit + 1;  
    	 int end = start + limit - 1;  
		
    	 try {
    		 map.clear();
    		 map.put("keyword", req1);
    		 map.put("start", start);
    		 map.put("end", end);
    		 return session.selectList(ns+"bookList1",map);
    	 } catch (Exception e) {			
    		 e.printStackTrace();		
    	 } finally {
    		 MybatisConnection.close(session);		
    	 }		
    	 return null;	
	 }
     
     //Book 테이블에 검색된 단어가 포함된 도서관이 있으면 해당 개수를 찾음
     public int bookCount1(String req1) {
    	 SqlSession session = MybatisConnection.getConnection();
			
    	 try {
    		 return session.selectOne(ns + "bookCount1",req1);
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 } finally {
    		 MybatisConnection.close(session);
    	 }
    	 return 0;
	 }
     
     //Book 테이블에 검색된 단어가 포함된 제목이 있으면 찾아서 리스트로 저장
     public List<Book> bookList2(String req2,int pageInt, int limit, int bookcount) {
    	 SqlSession session = MybatisConnection.getConnection();
	 		
    	 int start = (pageInt - 1) * limit + 1;  //시작 번호
    	 int end = start + limit - 1;  //end 번호
 		
    	 try {
    		 map.clear();
    		 map.put("keyword", req2);
    		 map.put("start", start);
    		 map.put("end", end);
    		 return session.selectList(ns+"bookList2",map);
    	 } catch (Exception e) {			
    		 e.printStackTrace();		
    	 } finally {
    		 MybatisConnection.close(session);		
    	 }		
    	 return null;	
 	 }
      
     //Book 테이블에 검색된 단어가 포함된 제목이 있으면 해당 개수를 찾음
     public int bookCount2(String req2) {
    	  SqlSession session = MybatisConnection.getConnection();
 			
    	  try {
    		  return session.selectOne(ns + "bookCount2",req2);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
 	  }
      
      //Book 테이블에 검색된 단어가 포함된 저자가 있으면 찾아서 리스트로 저장
      public List<Book> bookList3(String req3,int pageInt, int limit, int bookcount) {
    	  SqlSession session = MybatisConnection.getConnection();
	 		
    	  int start = (pageInt - 1) * limit + 1;  //시작 번호
    	  int end = start + limit - 1;  //end 번호
   		
    	  try {
    		  map.clear();
    		  map.put("keyword", req3);
    		  map.put("start", start);
    		  map.put("end", end);
    		  return session.selectList(ns+"bookList3",map);
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
   	  }
        
      //Book 테이블에 검색된 단어가 포함된 저자가 있으면 해당 개수를 찾음
      public int bookCount3(String req3) {
    	   SqlSession session = MybatisConnection.getConnection();
    	   try {
    		   return session.selectOne(ns + "bookCount3",req3);
    	   } catch (Exception e) {
    		   e.printStackTrace();
    	   } finally {
    		   MybatisConnection.close(session);
    	   }
    	   return 0;
   	  }
        
      //Book 테이블에 검색된 단어가 포함된 도서,제목이 있으면 찾아서 리스트로 저장
      public List<Book> bookList4(String req1,String req2,int pageInt, int limit, int bookcount) {
    	  SqlSession session = MybatisConnection.getConnection();
 	 		
    	  int start = (pageInt - 1) * limit + 1;  //시작 번호
    	  int end = start + limit - 1;  //end 번호
        		
    	  try {
    		  map.clear();
    		  map.put("keyword1", req1);
    		  map.put("keyword2", req2);
    		  map.put("start", start);
    		  map.put("end", end);
    		  return session.selectList(ns+"bookList4",map);
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
      }
        
      //Book 테이블에 검색된 단어가 포함된 도서,제목이 있으면 해당 개수를 찾음
      public int bookCount4(String req1, String req2) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  map.put("keyword1", req1);
    	  map.put("keyword2", req2);
    	  try {
    		  return session.selectOne(ns + "bookCount4",map);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
   	  }
       
      //Book 테이블에 검색된 단어가 포함된 도서,저자가 있으면 찾아서 리스트로 저장
      public List<Book> bookList5(String req1,String req3,int pageInt, int limit, int bookcount) {
    	  SqlSession session = MybatisConnection.getConnection();
  	 		
    	  int start = (pageInt - 1) * limit + 1;  //시작 번호
    	  int end = start + limit - 1;  //end 번호
        		
    	  try {
    		  map.clear();
    		  map.put("keyword1", req1);
    		  map.put("keyword2", req3);
    		  map.put("start", start);
    		  map.put("end", end);
    		  return session.selectList(ns+"bookList5",map);	
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
      }
       
      //Book 테이블에 검색된 단어가 포함된 도서,저자가 있으면 해당 개수를 찾음
      public int bookCount5(String req1, String req3) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  map.put("keyword1", req1);
    	  map.put("keyword2", req3);
    	   
    	  try {
    		  return session.selectOne(ns + "bookCount5",map);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
   	  }
     
      //도서 정보 Book테이블에 삽입
      public int BookInsert(Book book) {
    	  SqlSession session = MybatisConnection.getConnection();
   		
    	  try {
    		  session.insert(ns + "bookInsert", book);
    		  return 1;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
   	  }
     
      //해당 booknum(책번호)이 있는 데이터를 Book테이블에서 찾는다.
      public Book selectOne(int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
 		
    	  try {
    		  return session.selectOne(ns+"selectOne", booknum);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }
    	  return null;	
 	  }
      
      //Book테이블에서 해당 booknum(책번호)를 예약한 인원수 조회
      public int reserveCount(int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
			
    	  try {
    		  return session.selectOne(ns + "reserveCount",booknum);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
	  }
    
      
      //해당 booknum(책번호)이 있는 데이터를 Rental테이블에서 찾는다.
      public Rental rentalSelect(int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
   		
    	  try {
    		  return session.selectOne(ns+"rentalSelect", booknum);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }
    	  return null;	
      }
     
      //수정된 도서 내용이 Book테이블에 update되었는지 여부 확인
      public boolean bookUpdate(Book book) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  try {
    		  session.update(ns+"bookUpdate",book);
    		  return true;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return false;
 	  }
     
      //해당 booknum(도서 번호)이 Book테이블에서 삭제되었는지 확인(1이면 삭제됨)
      public int bookDelete(int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
		
    	  try {
    		  int cnt = session.update(ns+"bookDelete",booknum);
    		  return cnt;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
    
      //신착도서 리스트 - 검색폼에서 입력받은 req(연도-월)가 포함된 Book테이블에서의 데이터 리스트로 저장
      public List<Book> newbooklist(String req,int pageInt, int limit, int bookcount) {
    	  SqlSession session = MybatisConnection.getConnection();
	 		
    	  int start = (pageInt - 1) * limit + 1;  //시작 번호
    	  int end = start + limit - 1;  //end 번호
    		
    	  try {
    		  map.clear();
    		  map.put("keyword", req);
    		  map.put("start", start);
    		  map.put("end", end);
    		  return session.selectList(ns+"newbookList",map);
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
      }
    
      //검색폼에서 입력받은 req(연도-월)가 포함된 Book테이블에서의 데이터 개수로 찾기
      public int newbookcount(String req) {
    	  SqlSession session = MybatisConnection.getConnection();
			
    	  try {
    		  return session.selectOne(ns + "newbookcount",req);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
	  }
      
      //해당 booknum(책번호)와 memberid(회원 아이디)로 reservation 테이블에 있는지 확인(1이면 이미 예약된 상태)
      public int prebookReserve(int booknum,String memberid) {
    	  SqlSession session = MybatisConnection.getConnection();
      
    	  map.put("booknum", booknum);
    	  map.put("memberid", memberid);
    	 
    	  try {
    		  int num = session.selectOne(ns+"prebookReserve",map);
    		  return num;
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }	 
      
      //해당 booknum(책번호)가 rental테이블에 있어서 대출중인 상태인지 확인(a가1이면 대출중이어서 예약 가능)
      public int preRental(int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
       	
    	  try {
    		  int num = session.selectOne(ns+"prebookRental",booknum);
    		  return num;
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
     
      //해당 도서 정보를 reservation테이블에 삽입하여 예약(1이면 예약됨)
      public int bookReserveInsert(Bookreserve brsv) {
    	  SqlSession session = MybatisConnection.getConnection();
   		
    	  try {
    		  //예약번호 시퀀스로 만들어서 삽입
    		  int num = session.selectOne(ns +"rseqNextval");
    		  brsv.setRsvnum(num);
    		  session.insert(ns + "bookReserveInsert", brsv);
    		  return 1;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
   	  }
      
      //Reservation테이블에 해당 아이디가 포함된 데이터가 있으면 리스트로 저장
      public List<Bookreserve> bookreserveList(String memberid) {
    	  SqlSession session = MybatisConnection.getConnection();
  		
    	  try {
    		  return session.selectList(ns+"bookreserveList", memberid);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }
    	  return null;	
  	  }
     
      //해당 booknum(책 번호)과 memberid(회원아이디)가 포함된 데이터 Reservation테이블에서 삭제(1이면 삭제됨)
      public int bookReserveDelete(int booknum,String memberid) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  
    	  map.put("booknum", booknum);
    	  map.put("memberid", memberid);
     	
    	  try {
    		  int cnt = session.update(ns+"bookReserveDelete",map);
    		  return cnt;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
      
      //해당 도서 대출 정보가 담긴 내역을 Rental테이블에 삽입(1이면 삽입 성공)
      public int bookRentalInsert(Rental rental) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  try {
    		  //대출 번호는 시퀀스로 만들어 삽입
    		  int num = session.selectOne(ns +"rentalNextval");
    		  rental.setRentalnum(num);
    		  session.insert(ns + "bookRentalInsert", rental);
    		  return 1;
    	  }catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
      
      //해당 대출 번호가 있는 데이터를 Rental테이블에서 가져오기
      public Rental rentalselectOne(int rentalnum) {
    	  SqlSession session = MybatisConnection.getConnection();
   		
    	  try {
    		  return session.selectOne(ns+"rentalselectOne",rentalnum);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }
    	  return null;	
   	  }
      
      //해당 booknum(책번호)이 Rental테이블에 있으면 대출중(changestate)으로 변경
      public void bookStateUpdate(int booknum,String changestate) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  
    	  map.put("keyword", changestate);
    	  map.put("booknum", booknum);
    	 
    	  try {
    		  session.update(ns+"bookStateUpdate", map);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
   	  }
      
      //Rental테이블과 Reservation테이블에서 조인한 내용을 리스트로 저장
      public List<Join> selectRentalList(String memberid){
    	  SqlSession session = MybatisConnection.getConnection();
	 		
    	  try {
    		  return session.selectList(ns + "bookrentalList",memberid);
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
      }
      
      //해당 memberid,booknum(책번호)가 있는 데이터를 Rental테이블에서 삭제(num이 1이면 삭제됨)
      public int bookReturn(String memberid, int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  map.put("memberid", memberid);
    	  map.put("booknum", booknum);
       	
    	  try {
    		  int cnt = session.update(ns+"bookReturn",map);
    		  return cnt;
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
      
      //반납된 도서(booknum)는 대출가능(changestate) 상태로 변경
      public void bookReturnUpdate(int booknum,String changestate) {
    	  SqlSession session = MybatisConnection.getConnection();
      
    	  map.put("keyword", changestate);
    	  map.put("booknum", booknum);
    	  
    	  try {
    		  session.update(ns+"bookReturnUpdate", map);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
      }
      
      //Book테이블로 부터 대출횟수 순으로 순위를 정해서 top10리스트로 저장
      public List<Bestbook> bestBookList(){
    	  SqlSession session = MybatisConnection.getConnection();
	 		
    	  try {
    		  return session.selectList(ns + "bestBookList");
    	  } catch (Exception e) {			
    		  e.printStackTrace();		
    	  } finally {
    		  MybatisConnection.close(session);		
    	  }		
    	  return null;	
      }
      
     //해당 memberid와 booknum(책번호)를 가진 데이터 반납기한 연장(반납기한+7)
      public int returnRenew(String memberid, int booknum) {
      SqlSession session = MybatisConnection.getConnection();
       	 map.put("memberid", memberid);
       	 map.put("booknum", booknum);
       	
   		try {
   			int cnt = session.update(ns+"returnRenew",map);
   			return cnt;
   		} catch (Exception e) {
   			e.printStackTrace();
   		} finally {
   			MybatisConnection.close(session);
   		}
   		return 0;
        }
      
      //대출날짜와 반납예정 날짜의 차를 구하기
      public int period(String memberid,int booknum) {
    	  SqlSession session = MybatisConnection.getConnection();
    	  map.put("memberid", memberid);
    	  map.put("booknum", booknum);
    	  try {
    		  return session.selectOne(ns + "period",map);
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
	  }
      
}//end
      

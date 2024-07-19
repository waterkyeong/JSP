package model1.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class BoardDAO extends JDBConnect {

	public BoardDAO(ServletContext application) {
		super(application);
	}
	
//	검색조건에 맞는 게시물의 개수를 반환합니다.
	public int selectCount(Map<String,Object> map) {
		int totalCount = 0; //결과(게시물 수)를 담을 변수
		
		//게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT COUNT(*) FROM board";
		if(map.get("searchWord")!=null) {
			query+=" WHERE "+map.get("searchField")+" "+" LIKE '%"+map.get("searchWord")+"%' ";
		}
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getCon().createStatement(); //쿼리문 생성
			rs = stmt.executeQuery(query);//쿼리 실행
			rs.next(); // 커서를 첫 번째 행으로 이동
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	//검색 조건에 맞는 게시물 목록을 반환합니다.
	public List<BoardDTO> selectList(Map<String,Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM board";
		if(map.get("searchWord")!= null) {
			query += " WHERE "+ map.get("searchField")+ " "+"LIKE '%"+map.get("searchWord")+"%' ";
		}
		query+=" ORDER BY num DESC";
		try {
			stmt = getCon().createStatement(); //쿼리문 생성
			rs = stmt.executeQuery(query);//쿼리 실행
			
			while(rs.next()) { //결과를 순회
				//한 행(게시물 하나)의 내용을 DTO에 저장
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getString("num"));         //일련번호
				dto.setTitle(rs.getString("title"));	//제목
				dto.setContent(rs.getString("content"));//내용
				dto.setPostdate(rs.getDate("postdate"));//작성일
				dto.setId(rs.getString("id"));			//작성자 아이디
				dto.setVisitcount(rs.getString("visitcount"));//조회수
				
				bbs.add(dto); //결과 목록에 저장
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bbs;
	}
	
	//검색 조건에 맞는 게시물 목록을 반환합니다.(페이징 기능 지원)
	public List<BoardDTO> selectListPage(Map<String,Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//쿼리문 템플릿
		String query = "SELECT * FROM board";
		 if(map.get("searchWord") != null){
			 query+= " WHERE " + map.get("searchField")+" LIKE '%" + map.get("searchWord") + "%' ";
			 }
			 query += " ORDER BY num DESC limit ?,? ";
			 
		 try{
			 psmt= getCon().prepareStatement(query);
			 psmt.setInt(1, (int)map.get("start"));
			 psmt.setInt(2, (int)map.get("pageSize"));
			 
			 rs= psmt.executeQuery();
			 
			 while(rs.next()) { //결과를 순회
				 //한 행(게시물 하나)의 내용을 DTO에 저장
				 BoardDTO dto = new BoardDTO();
				 
				 dto.setNum(rs.getString("num"));         //일련번호
				 dto.setTitle(rs.getString("title"));	//제목
				 dto.setContent(rs.getString("content"));//내용
				 dto.setPostdate(rs.getDate("postdate"));//작성일
				 dto.setId(rs.getString("id"));			//작성자 아이디
				 dto.setVisitcount(rs.getString("visitcount"));//조회수
				 
				 bbs.add(dto); //결과 목록에 저장
			 }
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 return bbs;
	}
	
	//게시글 데이터를 받아 DB에 추가합니다.
	public int insertWrite(BoardDTO dto) {
		int result=0;
		PreparedStatement psmt = null;
		
		try {
			//insert 쿼리문 작성
			String query = "INSERT INTO board (title,content,id) VALUES(?,?,?)";
			psmt = getCon().prepareStatement(query); //동적 쿼리
			psmt.setString(1,dto.getTitle());
			psmt.setString(2,dto.getContent());
			psmt.setString(3,dto.getId());
			
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//지정한 게시물을 찾아 내용을 반환합니다.
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		
		//쿼리문 준비
		String query = "SELECT B.*, M.name FROM member M INNER JOIN board B ON M.id=B.id WHERE num=?";
		
		try {
			psmt = getCon().prepareStatement(query);
			psmt.setString(1, num);	//인파라미터를 일련번호로 설정
			rs = psmt.executeQuery();// 쿼리실행
			
			//결과 처리
			if(rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	//지정한 게시물의 조회수를 1 증가시킵니다.
	//executeQuery : select
	//executeUpdate : insert, update, delete
	public void updateVisitCount(String num) {
		//쿼리문 준비
		String query = "UPDATE board SET visitcount = visitcount+1 WHERE num=?";
		PreparedStatement psmt = null;
		try {
			psmt = getCon().prepareStatement(query);
			psmt.setString(1, num);	//인파라미터를 일련번호로 설정
			psmt.executeUpdate();// 쿼리실행
		}catch(Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}finally{
			try {
				psmt.close();
			} catch (SQLException e) {}
		}
	}
	// 지정한 게시물을 수정합니다.
	public int updateEdit(BoardDTO dto) {
		int result= 0;
		PreparedStatement psmt = null;
		
		try {
			//쿼리문 템플릿
			String query = "UPDATE board SET title=?, content=? WHERE num=?";
			
			//쿼리문 완성
			psmt = getCon().prepareStatement(query);
			psmt.setString(1,dto.getTitle());
			psmt.setString(2,dto.getContent());
			psmt.setString(3,dto.getNum());
			//쿼리문 실행
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}finally{
			try {
				psmt.close();
			} catch (SQLException e) {}
		}
		return result;//결과 반환
	}
	//지정한 게시물을 삭제합니다.
	public int deletePost(BoardDTO dto) {
		int result = 0;
		PreparedStatement psmt = null;
		 
		try {
			//쿼리문 템플릿
			String query = "DELETE FROM board WHERE num=?";
			
			//쿼리문 완성
			psmt = getCon().prepareStatement(query);
			psmt.setString(1,dto.getNum());
			
			//쿼리문 실행
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}finally{
			try {
				psmt.close();
			} catch (SQLException e) {}
		}
		return result;
	}
}

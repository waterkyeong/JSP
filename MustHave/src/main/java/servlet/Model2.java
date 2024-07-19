package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import membership.MemberDAO;
import model1.board.BoardDAO;
import model1.board.BoardDTO;

@WebServlet("/12Servlet/Study/Model2.do")
public class Model2 extends HttpServlet{
	private static final long  serialVersionUID = 1L;
	MemberDAO daom;
	BoardDAO daob;
	@PostConstruct
	public void myPostConstruct() {
		System.out.println("myPostConstruct() 호출");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");

		//application 내장 객체 얻기
		ServletContext application = this.getServletContext();

		//web.xml에서 DB연결 정보 얻기
		String driver = application.getInitParameter("MySQLDriver");
		String url = application.getInitParameter("MySQLURL");
		String id = application.getInitParameter("MySQLId");
		String pwd = application.getInitParameter("MySQLPwd");

		//DAO 생성
		daom = new MemberDAO(driver, url, id, pwd);
		daob = new BoardDAO(application);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("service() 호출");
		
		//전송 방식을 확인해 doGet() 혹은 doPost() 호출
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet() 호출");
		Map<String, Object> param = new HashMap<String, Object>();
		List<BoardDTO> boardList = daob.selectList(param);//게시물 목록 받기
		if(!boardList.isEmpty()) {
			req.setAttribute("message", boardList);
		}else {
			req.setAttribute("message", "등록된 게시글이 없습니다.");
		}
			req.getRequestDispatcher("/12Servlet/Study/Model2.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doPost() 호출");
		req.getRequestDispatcher("/12Servlet/Study/Model2.jsp").forward(req, resp);
	}
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
		daom.close();
		daob.close();
	}
	@PreDestroy
	public void myPreDestroy() {
		System.out.println("myPreDestroy() 호출");
		daom.close();
		daob.close();
	}
}

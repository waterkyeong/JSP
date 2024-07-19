package common;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;

public class JDBConnect {
	private Connection con;
	//기본 생성자
	public JDBConnect() {
		try {
			//jdbc 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DB에 연결
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//연결해제(자원 반납)
	public void close() {
		try {
			if(con !=null)con.close();
			
			System.out.println("JDBC 자원 해제");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//두 번째 생성자
	public JDBConnect(String driver, String url,String id, String pwd) {
		try {
			//JDBC 드라이버 로드
			Class.forName(driver);
			//DB에 연결
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자1)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//세 번째 생성자
	public JDBConnect(ServletContext application) {
		try {
			//JDBC 드리이버 로드
			String driver = application.getInitParameter("MySQLDriver");
			Class.forName(driver);
			
			//DB에 연결
			String url = application.getInitParameter("MySQLURL");
			String id = application.getInitParameter("MySQLId");
			String pwd = application.getInitParameter("MySQLPwd");
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(인수 생성자2)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}
}

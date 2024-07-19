/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-06-21 08:25:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._09PagingBoard;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import model1.board.BoardDAO;
import model1.board.BoardDTO;

public final class View_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("model1.board.BoardDTO");
    _jspx_imports_classes.add("model1.board.BoardDAO");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String num = request.getParameter("num"); //일련번호 받기

BoardDAO dao = new BoardDAO(application); //DAO생성
dao.updateVisitCount(num);	//조회수 증가
BoardDTO dto = dao.selectView(num);	//게시물 가져오기
dao.close();						//DB연결해제

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원제 게시판</title>\r\n");
      out.write("<script>\r\n");
      out.write("function deletePost(){\r\n");
      out.write("	var confirmed = confirm(\"정말로 삭제하시겠습니까?\");\r\n");
      out.write("	if(confirmed){\r\n");
      out.write("		var form = document.writeFrm;		//이름이 \"writeFrm\"인 폼 선택\r\n");
      out.write("		form.method = \"post\";				//전송방식\r\n");
      out.write("		form.action=\"DeleteProcess.jsp\";	//전송경로\r\n");
      out.write("		form.submit();						//폼값 전송\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Link.jsp", out, false);
      out.write("\r\n");
      out.write("<h2>회원제 게시판 - 상세보기(View)</h2>\r\n");
      out.write("<form name=\"writeFrm\">\r\n");
      out.write("	<input type=\"hidden\" name=\"num\" value=\"");
      out.print(num );
      out.write("\"/>\r\n");
      out.write("	<table border=\"1\" width=\"90%\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>번호</td>\r\n");
      out.write("			<td>");
      out.print(dto.getNum() );
      out.write("</td>\r\n");
      out.write("			<td>작성자</td>\r\n");
      out.write("			<td>");
      out.print(dto.getName() );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>작성일</td>\r\n");
      out.write("			<td>");
      out.print(dto.getPostdate() );
      out.write("</td>\r\n");
      out.write("			<td>조회수</td>\r\n");
      out.write("			<td>");
      out.print(dto.getVisitcount() );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>제목</td>\r\n");
      out.write("			<td colspan=\"3\">");
      out.print(dto.getTitle() );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>내용</td>\r\n");
      out.write("			<td colspan=\"3\" height=\"100\">");
      out.print(dto.getContent().replace("\r\n", "<br/>") );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"4\" align=\"center\">\r\n");
      out.write("				");
 
				if(session.getAttribute("UserId")!=null && session.getAttribute("UserId").toString().equals(dto.getId())){
				
      out.write("\r\n");
      out.write("				<button type=\"button\" onclick=\"location.href='Edit.jsp?num=");
      out.print(dto.getNum() );
      out.write("';\">수정하기</button>\r\n");
      out.write("				<button type=\"button\" onclick=\"deletePost();\">삭제하기</button>\r\n");
      out.write("				");
	
				}
				
      out.write("\r\n");
      out.write("				<button type=\"button\" onclick=\"location.href='List.jsp';\">목록 보기</button>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

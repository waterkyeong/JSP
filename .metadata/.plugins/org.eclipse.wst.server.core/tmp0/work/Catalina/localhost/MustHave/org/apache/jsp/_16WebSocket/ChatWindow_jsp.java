/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-07-03 03:53:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._16WebSocket;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class ChatWindow_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>웹소켓 채팅</title>\r\n");
      out.write("<script>\r\n");
      out.write("var wevSocket = new WebSocket(\"");
      out.print( application.getInitParameter("CHAT_ADDR"));
      out.write("/ChatingServer\");\r\n");
      out.write("var chatWindow, chatMessage,chatId;\r\n");
      out.write("\r\n");
      out.write("//채팅창이 열리면 대화창, 메시지 입력창, 대화명 표시란으로 사용할 DOM 객체 저장\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("	chatWindow = document.getElementById(\"chatWindow\");\r\n");
      out.write("	chatMessage = document.getElementById(\"chatMessage\");\r\n");
      out.write("	chatId= document.getElementById('chatId').value;\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//메세지 전송\r\n");
      out.write("function sendMessage(){\r\n");
      out.write("	//대화창에 표시\r\n");
      out.write("	chatWindow.innerHTML += \"<div class='myMsg'>\"+chatMessage.value + \"</div>\"\r\n");
      out.write("	webSocket.send(chatId + '|'+chatMessage.value)//서버로 전송\r\n");
      out.write("	chatMessage.value=\"\";//메세지 입력창 내용 지우기\r\n");
      out.write("	chatWindow.scrollTop = chatWindow.scrollHeight; //대화창 스크롤\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//서버와의 연결 종료\r\n");
      out.write("function disconnect(){\r\n");
      out.write("	webSocket.close();\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//엔터 키 입력 처리\r\n");
      out.write("function enterKey(){\r\n");
      out.write("	if(window.event.keyCode == 13){//13은 'Enter'키의 코드값\r\n");
      out.write("		sendMessage();\r\n");
      out.write("	}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//웹소켓 서버에 연결됐을 때 실행\r\n");
      out.write("webSocket.onopen = function(event){\r\n");
      out.write("	chatWindow.innerHTML +=\"웹소켓 서버에 연결되었습니다. <bt/>\";\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//웹소켓 서버에 닫혔을 때 실행\r\n");
      out.write("webSocket.onclose = function(event){\r\n");
      out.write("	chatWindow.innerHTML +=\"웹소켓 서버가 종료되었습니다. <bt/>\";\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//에러 발생시 실행\r\n");
      out.write("webSocket.onerror = function(event){\r\n");
      out.write("	alert(event.data);\r\n");
      out.write("	chatWindow.innerHTML += \"채팅 중 에러가 발생하였습니다. <br/>\";\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//메세지를 받았을 때 실행\r\n");
      out.write("webSocket.onmessage = function(event){\r\n");
      out.write("	var message = event.data.split(\"|\");	//대화명과 메세지 분리\r\n");
      out.write("	var sender = message[0];	//보낸사람 대화명\r\n");
      out.write("	var content = message[1];	//메세지 내용\r\n");
      out.write("	if(content != \"\"){//귓속말\r\n");
      out.write("		if(content.match((\"/\"+chatId))){  //나에게 보낸 메세지만 출력\r\n");
      out.write("			var temp = content.replace((\"/\"+chatId),\"[귓속말] : \");\r\n");
      out.write("			chatWindow.innerHTML += \"<div>\" + sender +\"\"+tmep+\"</div>\";\r\n");
      out.write("		}	\r\n");
      out.write("	}else{//일반 대화\r\n");
      out.write("		chatWindow.innerHTML += \"<div>\" + sender +\"\"+content+\"</div>\";\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("chatWindow.scrollTop = chatWindow.scrollHeight;\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("#chatWindow{border:1px solid black; width:270px; height:310px; overflow:scroll; padding:5px;}\r\n");
      out.write("#chatMessage{width:236px; height:30px}\r\n");
      out.write("#sendBtn{height:30px; position:relative; top:2px; left:-2px}\r\n");
      out.write("#closeBtb{margin-bottom:3px; position:relative; top:2px; left:-2px}\r\n");
      out.write("#chatId{width:158px; height:24px; border:1px solid #AAAAAA; background-color:#EEEEEE;}\r\n");
      out.write(".myMsg{text-align:right;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	대화명 : <input type=\"text\" id=\"chatId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.chatId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly />\r\n");
      out.write("	<button id=\"closeBtn\" onclick=\"disconnect();\">채팅종료</button>\r\n");
      out.write("	<div id=\"chatWindow\"></div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<input type=\"text\" id=\"chatMessage\" onkeyup=\"enterkey();\">\r\n");
      out.write("		<button id=\"sendBtn\" onclick=\"sendMessage();\">전송</button>\r\n");
      out.write("	</div>\r\n");
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

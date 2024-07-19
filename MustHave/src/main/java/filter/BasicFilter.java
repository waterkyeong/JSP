package filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class BasicFilter implements Filter {
	FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		config = filterConfig;
		String filterName = filterConfig.getFilterName();
		
		System.out.println("BasicFilter -> init() 호출됨 : "+filterName);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String filterInitParam = config.getInitParameter("FILTER_INIT_PARAM");
		System.out.println("BasicFilter -> 초기화 매개변수 : "+ filterInitParam);
		
//		String method = request.getMethod(); 에러발생(형변환 후 호출할 수 있음)
		String method = req.getMethod();
		
//		체인 대신 사용가능...?
//		if(method.equalsIgnoreCase("POST")) {
//			HttpServletRequest resp = (HttpServletRequest)response;
//			resp.setContentType("test/html; charset=utf-8");
//			PrintWriter out = resp.getWriter();
//			out.println("<h1>post is not allwed</h1>");
//			out.close();
//		}
		
		System.out.println("BasicFilter -> 전송방식 : "+method);
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("BasicFilter -> destroy() 호출됨");
	}
}

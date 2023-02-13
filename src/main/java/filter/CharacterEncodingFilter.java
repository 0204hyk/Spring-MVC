package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	// 패키지를 그냥 만들면 스프링에서 자동 수거를 하지 않는다.
	// 필터를 만든 후에 web.xml에 등록해야한다.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터에서 처리중입니다.");
		
		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("처리가 끝났습니다.. 다음 필터로 이동합니다.");
		// 필터가 여러개라는 가정을 하고 이 필터의 처리는 끝났으니 다음 필터로 간다는 의미
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}

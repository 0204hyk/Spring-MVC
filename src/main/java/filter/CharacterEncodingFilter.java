package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	// ��Ű���� �׳� ����� ���������� �ڵ� ���Ÿ� ���� �ʴ´�.
	// ���͸� ���� �Ŀ� web.xml�� ����ؾ��Ѵ�.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���Ϳ��� ó�����Դϴ�.");
		
		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("ó���� �������ϴ�.. ���� ���ͷ� �̵��մϴ�.");
		// ���Ͱ� ��������� ������ �ϰ� �� ������ ó���� �������� ���� ���ͷ� ���ٴ� �ǹ�
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}

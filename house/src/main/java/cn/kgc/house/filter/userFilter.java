package cn.kgc.house.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class userFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        List pagelist = new ArrayList();
        pagelist.add("/page/fabu.jsp");
        pagelist.add("/page/guanli.jsp");
        if (!pagelist.contains(uri)){
            filterChain.doFilter(request,servletResponse );
        }else {
            Object o=session.getAttribute("userinfo");
            if(o==null){
                servletResponse.getWriter().write("<script>alert('未登录，不能浏览内容！');location.href='/page/login.jsp';</script>");
            }else {
                filterChain.doFilter(request,servletResponse );
            }
        }
    }

    @Override
    public void destroy() {

    }
}

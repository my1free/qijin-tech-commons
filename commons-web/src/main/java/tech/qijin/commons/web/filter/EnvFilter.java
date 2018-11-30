package tech.qijin.commons.web.filter;

import tech.qijin.commons.web.pojo.EnvEnum;
import tech.qijin.commons.web.util.EnvUtil;
import tech.qijin.commons.web.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author michealyang
 * @date 2018/11/23
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class EnvFilter implements Filter {

    private static final String TEST_KEYWORD = "test";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String host = ServletUtil.getHost((HttpServletRequest) request);
        EnvEnum envEnum = host.contains(TEST_KEYWORD)
                ? EnvEnum.TEST
                : EnvEnum.PRODUCT;
        EnvUtil.setEnv(envEnum);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

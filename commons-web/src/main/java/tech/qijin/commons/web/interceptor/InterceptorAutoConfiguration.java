package tech.qijin.commons.web.interceptor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.qijin.commons.web.filter.EnvFilter;
import tech.qijin.commons.web.filter.RequestFilter;
import tech.qijin.commons.web.filter.TraceFilter;

/**
 * @author michealyang
 * @date 2018/11/23
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
//@Configuration
@ConditionalOnMissingBean({RequestFilter.class, TraceFilter.class, EnvFilter.class})
public class InterceptorAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceInterceptor()).excludePathPatterns(InterceptorExclusion.COMMON);
        registry.addInterceptor(new EnvInterceptor()).excludePathPatterns(InterceptorExclusion.COMMON);
        registry.addInterceptor(new RequestInterceptor()).excludePathPatterns(InterceptorExclusion.COMMON);
    }
}

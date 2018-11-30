package tech.qijin.commons.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author michealyang
 * @date 2018/11/26
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
@Order(1)
public class InterceptorConfig3 implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor1());
        registry.addInterceptor(new Interceptor2());
    }
}
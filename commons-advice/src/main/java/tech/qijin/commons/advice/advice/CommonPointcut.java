package tech.qijin.commons.advice.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yangshangqiang
 * @date 2018/11/2
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 * @refer: Tutorials:: http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop
 **/
public class CommonPointcut {
    @Pointcut("@annotation(tech.qijin.commons.advice.annotation.Retry)")
    public void retryAnnotationPointcut() {}

    @Pointcut("@annotation(tech.qijin.commons.advice.annotation.Timed)")
    public void timedAnnotationPointcut() {}

    @Pointcut("@annotation(tech.qijin.commons.advice.annotation.Cas)")
    public void casAnnotationPointcut() {}
}

package com.aviagames.commons.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.qijin.commons.lang.constant.EnvEnum;
import tech.qijin.commons.trace.TraceUtil;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * 向数据库的table中默认插入env的值
 * <p>
 * env值的获取方式推荐使用ThreadLocal<br>
 * 这里使用
 * </p>
 *
 * @author michealyang
 * @date 2018/11/7
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class EnvInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnvInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object object = invocation.getArgs()[1];
        //sql类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        if (SqlCommandType.INSERT.equals(sqlCommandType)) {
            //插入操作时，自动插入env
            EnvEnum envEnum = TraceUtil.getEnv();
            Field fieldEnv = object.getClass().getDeclaredField("env");
            fieldEnv.setAccessible(true);
            fieldEnv.set(object, envEnum);
        }else{
            if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                //update时，自动更新updated_at
                Field fieldUpdatedAt = object.getClass().getDeclaredField("updated_at");
                fieldUpdatedAt.setAccessible(true);
                fieldUpdatedAt.set(new Date(), object);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

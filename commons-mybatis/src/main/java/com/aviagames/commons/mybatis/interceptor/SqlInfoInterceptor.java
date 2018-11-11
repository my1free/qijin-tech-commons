package com.aviagames.commons.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**打印sql执行信息
 * <p>
 *     <li>执行时间</li>
 *     <li>sql语句</li>
 *     <li>affect rows</li></li>
 * </p>
 * @author michealyang
 * @date 2018/11/11
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class SqlInfoInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger("MyBatis");
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        Configuration configuration = mappedStatement.getConfiguration();
        Object target = invocation.getTarget();
        StatementHandler handler = configuration.newStatementHandler((Executor) target, mappedStatement,
                parameter, RowBounds.DEFAULT, null, null);
        //记录SQL
        BoundSql boundSql = handler.getBoundSql();
        //记录耗时
        long start = System.currentTimeMillis();
        //执行真正的方法
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        //记录影响行数
        int affectedRows = Integer.valueOf(Integer.parseInt(result.toString()));
        //记录时间

        LOGGER.info("executed times: {}, sql: {}, affected rows: {}, time cost: {} ms",
                new Date(), boundSql.getSql(), affectedRows, end - start);

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

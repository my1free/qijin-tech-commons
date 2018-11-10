package tech.qijin.commons.trace;

import tech.qijin.commons.lang.constant.EnvEnum;
import tech.qijin.commons.trace.pojo.Trace;

/**
 * @author michealyang
 * @date 2018/11/7
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class TraceUtil {
    private static ThreadLocal<Trace> traceThreadLocal = new ThreadLocal();

    public static void setTracer(Trace trace) {
        if (null== trace){
            throw new NullPointerException("trace is null");
        }
        traceThreadLocal.set(trace);
    }

    public static Trace getTracer() {
        return traceThreadLocal.get();
    }

    public static String getTraceId() {
        return traceThreadLocal.get().getTraceId();
    }

    public static EnvEnum getEnv() {
        return traceThreadLocal.get().getEnv();
    }

    public static void remove() {
        traceThreadLocal.remove();
    }
}

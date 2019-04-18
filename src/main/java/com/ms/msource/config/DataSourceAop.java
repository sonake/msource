package com.ms.msource.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(com.ms.msource.config.Master) " +
            "&& (execution(* com.ms.msource.service..*.select*(..)) " +
            "|| execution(* com.ms.msource.service..*.get*(..)))")
    public void readPointcut(){

    }
    @Pointcut("@annotation(com.ms.msource.config.Master) " +
            "|| execution(* com.ms.msource.service..*.insert*(..)) " +
            "|| execution(* com.ms.msource.service..*.add*(..)) " +
            "|| execution(* com.ms.msource.service..*.update*(..)) " +
            "|| execution(* com.ms.msource.service..*.edit*(..)) " +
            "|| execution(* com.ms.msource.service..*.delete*(..)) " +
            "|| execution(* com.ms.msource.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}

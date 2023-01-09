package com.tj.exercise.ppmt.configure.center.demo.common.util;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.target.SingletonTargetSource;

/**
 * @Author: tj
 * @Date: 2023/1/8 20:08
 */
public class AopTargetUtil {
    public static  Object getTarget(Object proxyTarget){
        while (proxyTarget instanceof Advised) {
            TargetSource targetSource = ((Advised) proxyTarget).getTargetSource();
            if (targetSource instanceof SingletonTargetSource) {
                proxyTarget = ((SingletonTargetSource) targetSource).getTarget();
            }
        }

        return proxyTarget;
    }
}

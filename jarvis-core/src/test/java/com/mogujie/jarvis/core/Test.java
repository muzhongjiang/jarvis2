package com.mogujie.jarvis.core;

/**
 * Created by lixun on 2017/9/13.
 */
public class Test {
    @org.junit.Test
    public void test(){

        String format = String.format("%s 重跑任务 %s, 重跑起始时间为%s,重跑截止时间为%s", "ruson", "jarvis-web", 1505145600000l, 1505302500000l);
        System.out.println(format);

    }
}

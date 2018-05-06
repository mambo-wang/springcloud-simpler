package com.wb.wbao.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dell on 2018/5/5.
 */
public class GamePlayIH implements InvocationHandler {
    //被代理者
    Class cls =null;
    //被代理者实例
    Object obj = null;
    //构造函数
    public GamePlayIH(Object _obj){
        this.obj = _obj;
    }

    /**
     * /调用被代理的方法
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 方法参数
     * @return 方法返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("开始代理");
        Object result = method.invoke(this.obj, args);
        System.out.println("结束代理");
        return result;
    }
}
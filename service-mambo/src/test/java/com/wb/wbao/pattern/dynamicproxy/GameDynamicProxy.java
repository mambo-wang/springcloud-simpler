package com.wb.wbao.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;

/**
 * 具体业务的动态代理
 */
public class GameDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(IGamePlayer gamePlayer){
        ClassLoader loader = gamePlayer.getClass().getClassLoader();
        Class<?>[] classes = gamePlayer.getClass().getInterfaces();
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        return newProxyInstance(loader, classes, handler);
    }
}

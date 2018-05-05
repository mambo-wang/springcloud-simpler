package com.wb.wbao.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2018/5/5.
 */
public class Client {
    public static void main(String[] args) throws Throwable {
        IGamePlayer player = new GamePlayer("wbao");
        InvocationHandler handler = new GamePlayIH(player);
        ClassLoader cl = player.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, player.getClass().getInterfaces(), handler);
        proxy.login("wbao", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
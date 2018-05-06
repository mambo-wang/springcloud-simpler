package com.wb.wbao.pattern.dynamicproxy;


/**
 * Created by dell on 2018/5/5.
 */
public class Client {
    public static void main(String[] args) throws Throwable {
        IGamePlayer player = new GamePlayer("wbao");
        //动态产生一个代理者
        IGamePlayer proxy = GameDynamicProxy.newProxyInstance(player);
        proxy.login("wbao", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
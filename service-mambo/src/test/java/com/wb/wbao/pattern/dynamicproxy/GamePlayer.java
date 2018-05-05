package com.wb.wbao.pattern.dynamicproxy;

/**
 * Created by dell on 2018/5/5.
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";
    //􄗮􄖛􁵘􄗴􀟑􁭄􀓴􄗦􀧡􂿄
    public GamePlayer(String _name){
        this.name = _name;
    }
    //􁠧􁗾􀋈􁳔􁳳􁳯􂱘􁈅􁰃􁴔􃗕􁗾
    public void killBoss() {
        System.out.println(this.name + "打怪");
    }
    //􄖯􂐌􁟣􀐟􀠡􀔴􃚃􁅮􃽕􂱏􁔩􀧻􀋈􄖭􁰃􀏔􀏾􁖙􃽕􁴵􀓊
    public void login(String user, String password) {
        System.out.println("登录名"+user+"的用户"+this.name+"登录成功");
    }
    //􀤛􃑻􀋈􀤛􃑻􁳝􁕜􀻮􁮍􂊩􀋈􃢅􄪅􀑄􁰃􀏔􂾡􀋈􀘮􀓏􀡵􀐳􁰃􀏔􂾡
    public void upgrade() {
        System.out.println(this.name + "升级了");
    }
}

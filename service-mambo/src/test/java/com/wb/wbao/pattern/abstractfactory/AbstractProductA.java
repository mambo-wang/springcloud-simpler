package com.wb.wbao.pattern.abstractfactory;

public abstract class AbstractProductA {
    /**共有方法*/
    public void shareMethod(){

    }

    //每个产品有各自的实现
    public abstract void doSomething();
}

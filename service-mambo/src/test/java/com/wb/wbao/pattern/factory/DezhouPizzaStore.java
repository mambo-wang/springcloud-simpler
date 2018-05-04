package com.wb.wbao.pattern.factory;

public class DezhouPizzaStore extends PizzaStore {
    @Override
    protected <T extends Pizza> T createPizza(Class<T> c) {

        Pizza pizza = null;
        try {
            pizza = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("error");
        }
        return (T) pizza;
    }
}

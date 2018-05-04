package com.wb.wbao.pattern.factory;

public abstract class PizzaStore {

    public <T extends Pizza> T orderPizza(Class<T> c){

        Pizza pizza;

        pizza = createPizza(c);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return (T) pizza;
    }

    protected abstract <T extends Pizza> T createPizza(Class<T> c);

}

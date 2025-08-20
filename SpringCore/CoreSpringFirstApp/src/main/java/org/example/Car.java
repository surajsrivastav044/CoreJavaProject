package org.example;

public class Car {

    Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        int start=engine.start();
        if(start>=1){
            System.out.println("Let's drive....");
        }else{
            System.out.println("Engine not started yet sorry....");
        }
    }
}

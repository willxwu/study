package com.example.study.java8.InterfaceFunction;

/**
 * 哪些是funcationInterface接口？
 * 1、除了default、static的方法外，只有一个方法的接口，就是funcationInteface
 * 2、 //继承后不止一个方法的接口不是funcationInterface
 */
public class LambdaFunctionInterface {

    //1、除了default、static的方法外，只有一个方法的接口，就是funcationInteface
    @FunctionalInterface
    interface Adder{
        int add(int a, int b);
    }

    //2、继承后不止一个方法，因此不是funcationInterface
    interface SmartAdder extends Adder{
        int add(Long a, Long b);
    }

    //3、没有方法，但继承了有一个方法的接口是funcationInterface
    @FunctionalInterface
    interface Empty extends Adder{

    }

    //4、没有任何方法的接口，不是funcationInterface
    interface DoNothing{

    }


}

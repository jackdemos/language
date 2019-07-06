package com.taocaicai.language;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectTest {

    public static void main(String[] args) {
        for(Method method:Student.class.getMethods()){
            System.out.println("方法名称:\t"+method.getName());
            for (Parameter parameters : method.getParameters()){
                System.out.print("\t方法参数:\t"+parameters.getName());
                System.out.println("\t参数类型:\t"+parameters.getType().getName());
            }
        }
    }
}

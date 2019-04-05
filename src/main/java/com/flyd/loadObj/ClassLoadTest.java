package com.flyd.loadObj;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试
 * 类加载以及实现get方法
 *
 */
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.flyd.genobj.model.TestClass");


        Method[] methods = clazz.getDeclaredMethods();
        printGetMethods(clazz, methods);

    }

    /**
     * 实现get方法
     * @param clazz
     * @param methods
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static void printGetMethods(Class clazz ,Method[] methods) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Method method:methods)
        {
            if (method.getName().contains("get")){
                Object obj = clazz.newInstance();
                System.out.println(method.getName());
                String result = (String)method.invoke(obj,null);
                System.out.println(result);
            }
        }
    }

    public static void printSetMethods(Method[] methods){
        for (Method method:methods)
        {
            if (method.getName().contains("set")){
                System.out.println(method.getName());
            }
        }
    }




}

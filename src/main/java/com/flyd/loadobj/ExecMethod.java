package com.flyd.loadobj;

import com.flyd.utils.CharasetUtil;
import com.flyd.utils.CustomClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试
 * 类加载以及实现get方法
 *
 */
public class ClassLoadTest {

    public static String printStringMethod(String className,String filed){
        Object obj = null;
        try {

            Class clazz = Class.forName(CustomClass.modelPath+"."+className);
            Method method = clazz.getMethod("get"+ CharasetUtil.toUp(filed));
            obj = clazz.newInstance();
            return (String)method.invoke(obj,null);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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

package com.flyd.javaobj.loadobj;

import com.flyd.javaobj.genobj.JavaC;
import com.flyd.utils.CharasetUtil;
import com.flyd.utils.CustomClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试
 * 类加载以及实现get方法
 */
public class ExecMethod {




    public static String printStringMethod(String className, String filed) {
        try {
            Class clazz = Class.forName(CustomClass.modelPath + "." + className);
            Method method = clazz.getMethod("get" + CharasetUtil.toUp(filed));
            Object obj = clazz.newInstance();
            return (String) method.invoke(obj, null);

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

}

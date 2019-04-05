package com.flyd.loadobj;

import com.flyd.utils.CharasetUtil;
import com.flyd.utils.CustomClass;
import sun.applet.AppletClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试
 * 类加载以及实现get方法
 */
public class ExecMethod {


    public static void compilerJavaFile(String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int status = compiler.run(null, null, null, "-d",
                System.getProperty("user.dir") + "/target/classes", CustomClass.getJavaFileRealPath() + "/" + className + ".java");
        if (status != 0) {
            System.out.println("没有编译成功");
        }
    }


    public static String printStringMethod(String className, String filed) {
        try {
            compilerJavaFile(className);
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

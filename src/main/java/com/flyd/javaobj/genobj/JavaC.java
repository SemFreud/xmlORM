package com.flyd.javaobj.genobj;

import com.flyd.utils.CustomClass;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JavaC {

    public static void compilerJavaFile(String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int status = compiler.run(null, null, null, "-d",
                CustomClass.getAfterJavaFileCompileRealPath(), CustomClass.getJavaFileRealPath() + "/" + className + ".java");
        if (status != 0) {
            System.out.println("没有编译成功");
        }



    }
}

package com.flyd.javaobj.genobj;


import com.flyd.utils.CustomClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 测试 构建类
 */
public class GenObj {


    public static void genJavaModel(String className, String... fileds) {

        File outFile = new File(CustomClass.getJavaFileRealPathName(className));
        System.out.println(outFile.getAbsolutePath());
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdir();
        }
        try {
            outFile.createNewFile();
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outFile));
            JavaBuilder javaBuilder = new JavaBuilder();
            String result = javaBuilder.buildJava(className, fileds);
            writer.write(result);
            writer.flush();

            //编译该java文件
            JavaC.compilerJavaFile(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
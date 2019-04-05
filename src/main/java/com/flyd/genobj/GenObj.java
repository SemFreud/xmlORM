package com.flyd.genobj;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 测试 构建类
 */
public class GenObj {
    public static void main(String[] args) throws IOException {
        String path = GenObj.class.getPackage().getName().replace('.', '/') + "/model";
        String packName = GenObj.class.getPackage().getName() + ".model";

        String className = "TestClass";
        String resultPath = System.getProperty("user.dir");
        String filePath = resultPath + "/src/main/java/" + path;
        File outFile = new File(filePath + "/" + className + ".java");
        System.out.println(outFile.getAbsolutePath());
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdir();
        }
        outFile.createNewFile();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outFile));
        JavaBuilder javaBuilder = new JavaBuilder();
        String[] fileds = {"id", "name", "age"};
        String result = javaBuilder.buildJava(packName, className, fileds);
        writer.write(result);
        writer.flush();
    }

}

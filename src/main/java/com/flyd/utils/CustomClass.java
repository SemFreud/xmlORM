package com.flyd.utils;

/**
 * 定义包的地址等
 */
public class CustomClass {
    public static final String modelPackagePath = "com.flyd.model";

    public static final String modelPath = modelPackagePath.replace(".","/");
    public static final String absPack = "/src/main/java/";
    
    public static String getJavaFileRealPath() {
        String applicationPath = System.getProperty("user.dir");
        return applicationPath+"/"+absPack+modelPackagePath.replace(".","/");
    }

    public static String getJavaFileRealPathName(String className){
        return getJavaFileRealPath()+"/"+className+".java";
    }
}

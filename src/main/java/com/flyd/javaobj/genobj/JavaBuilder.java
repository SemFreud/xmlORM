package com.flyd.javaobj.genobj;

import com.flyd.utils.CharasetUtil;
import com.flyd.utils.CustomClass;

/**
 * 构建类的信息
 */
public class JavaBuilder {
    private static StringBuffer stringBuilder = new StringBuffer();
    private final String TABSPLIT = "    ";

    public String buildJava(String className,String... fileds){
        JavaBuilder builder = new JavaBuilder();

        builder.genPackInfo(CustomClass.modelPackagePath);
        builder.genClassInfoTop(className);
        builder.genFiledsInfo(fileds);
        builder.genGetMethodsInfo(fileds);
        builder.genSetMethodsInfo(fileds);
        builder.genClassInfoLow();
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private StringBuffer genPackInfo(String packName){
        return stringBuilder.append("package ").append(packName).append(";\n\n");
    }

    private StringBuffer genClassInfoTop(String className){
        return stringBuilder.append("public class ").append(className).append("{\n");
    }

    private StringBuffer genFiledsInfo(String... fileds){
        for (String filed : fileds)
        {
            stringBuilder.append(TABSPLIT).append("private String ").append(filed).append(";\n");
        }
        return stringBuilder;
    }

    private StringBuffer genSetMethodsInfo(String... fileds){
        for(String filed:fileds){

            stringBuilder.append("\n").append(TABSPLIT).append("public void set").append(CharasetUtil.toUp(filed)).append("(String ").append(filed).append(") {\n");
            stringBuilder.append(TABSPLIT).append(TABSPLIT).append("this.").append(filed).append("=").append(filed).append(";\n");
            stringBuilder.append(TABSPLIT).append("}\n");
        }
        return stringBuilder;
    }

    private StringBuffer genGetMethodsInfo(String... fileds){
        for(String filed:fileds){
            stringBuilder.append("\n").append(TABSPLIT).append("public String get").append(CharasetUtil.toUp(filed)).append("() {\n");
            stringBuilder.append(TABSPLIT).append(TABSPLIT).append("return this.").append(filed).append(";\n");
            stringBuilder.append(TABSPLIT).append("}\n");
        }
        return stringBuilder;
    }

    private StringBuffer genClassInfoLow(){
        return stringBuilder.append("}\n");
    }



}

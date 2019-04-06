package com.flyd;

import com.flyd.javaobj.genobj.GenObj;
import com.flyd.javaobj.loadobj.ExecMethod;

public class APP {
    public static void main(String[] args) throws InterruptedException {
        String className = "TestFour";
        String[] fileds = {"licongcong","xubangbang","yeyihui"};

        GenObj.genJavaModel(className,fileds);

        for (String filed:fileds)
        {
            System.out.println(ExecMethod.printStringMethod(className,filed));;
        }
    }
}

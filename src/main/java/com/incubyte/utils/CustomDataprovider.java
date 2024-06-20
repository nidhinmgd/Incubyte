package com.incubyte.utils;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;


public class CustomDataprovider {

    @DataProvider(name = "TC_01")
    public Object[][] methodBasedDataProvider(Method method) {
        String testMethodName = method.getName();
        if ("TC01_SignUp".equals(testMethodName)) {
            return new Object[][]{{"Abhishek","Abhi","Abhi@gmai.com","Pass@1234","Pass@1234"}};
        } else if ("TC02_SignIn".equals(testMethodName)) {
            return new Object[][]{{"Abhishek","Abhi","Abhi@gmai.com","Pass@1234"}};
        } else if ("TC03_InvalidSignUp".equals(testMethodName)) {
            return new Object[][]{{"Abhishek","Abhi","Abhi1@gmail.com","Pass@1234","Pass@12345"}};
        }else if ("TC04_InvalidSignIn".equals(testMethodName)) {
            return new Object[][]{{"Abhi1@gmail.com","Pass@12345"}};
        }
        return new Object[][]{};
    }
}

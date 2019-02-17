package com.lcl.test;

import com.lcl.Context.IOCcontext;
import com.lcl.pojo.Student;

public class TestIOC {
    public static void main(String[] args) {
        IOCcontext context = new IOCcontext();
        /*
        获取一个对象 student
         */
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}

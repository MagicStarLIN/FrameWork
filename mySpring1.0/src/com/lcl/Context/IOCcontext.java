package com.lcl.Context;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class IOCcontext {
    //    properties文件格式
//    #注释
//    id=class,default
//    id-属性名=属性值
//    id-属性名=idRef
    //[1] 建立Map 存储关系键值对
    //#1 id与class键值对
    private static Map<String, String> idClassMap = new HashMap<String, String>();
    //#2 id与属性值
    private static Map<String, HashMap<String, Object>> idProperty = new HashMap<String, HashMap<String, Object>>();
    //#3 创建一个Object列表 存储object？


    //在静态块中读取配置文件 获取信息
    static {
        //创建流来读取配置文件
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/cfg.propreties")));
            //存储读取的信息
            String context = null;
            //存储属性信息的 map集合
            Map<String, Object> properties = null;
            //解析context
            while ((context = reader.readLine()) != null) {
                if (context.contains("#")) {
                    continue;
                }
                //1、使用=拆分
                //拆分的结果 id=class   id-propName=propValue
                String[] contextArr = context.split("=");
                // ① id-propName=propValue
                if (contextArr[0].contains("-")) {
                    String[] propArr = contextArr[0].split("-");
                    String propName = propArr[1];
                    String propValue = contextArr[1];

                    //propValue 可能是一个对象
                    Object objectValue = propValue;
                    try {
                        objectValue = Integer.parseInt(propValue);
                    } catch (Exception e) {
                        objectValue = propValue;
                    } finally {
                        if (propValue.contains(".")) {
                            objectValue = Class.forName(propValue).newInstance();

                        }
                        properties.put(propName, objectValue);
                    }

                } else {
                    //②id=class
                    properties = new HashMap<String, Object>();
                    idClassMap.put(contextArr[0], contextArr[1]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id) {
        Object obj = null;
        String className = idClassMap.get(id);
        Class Clazz = null;
        try {
            Clazz = Class.forName(className);
            obj = getBean(id, Clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private Object getBean(String id, Class clazz) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
            setProperty(id,obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //给对象赋值
    private void setProperty(String id, Object obj) {
        HashMap<String, Object> properties = idProperty.get(id);
        Class clazz = obj.getClass();
        if (properties != null && !properties.isEmpty()) {
            Set<Map.Entry<String, Object>> entrySet = properties.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                String propName = entry.getKey();
                Object propValue = entry.getValue();
                for (String eid : idClassMap.keySet()) {
                    if (propValue.equals(eid)) {
                        propValue = getBean(eid);
                        break;
                    }
                }
                //利用反射 调用set方法进行赋值
                String FirstName = propName.substring(0,1).toUpperCase();
                String LastName = propName.substring(1);
                String methodName = "set"+FirstName+LastName;

                try {
                    Method method = clazz.getDeclaredMethod(methodName,propValue.getClass());
                    method.invoke(obj,propValue);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

package com.example;

import com.example.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        Method method = r.getClass().getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);
        // TODO : invoke r.toString via reflection
        System.out.println(r);
    }
}

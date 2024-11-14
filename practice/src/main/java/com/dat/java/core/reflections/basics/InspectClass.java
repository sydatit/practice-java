package com.dat.java.core.reflections.basics;

import com.dat.java.core.reflections.domain.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class InspectClass {
    public static void main(String[] args) {
        inspectClass(User.class);
    }

    private static void inspectClass(Class<?> clazz) {
        listPublicConstructors(clazz);
        listPrivateConstructors(clazz);
//
//        listPublicMethods(clazz);
//        listPrivateMethods(clazz);
//
//        listPublicFields(clazz);
//        listPrivateFields(clazz);
    }

    private static void listPublicConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("Public Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("\tName: " + constructor.getName());
            System.out.println("\tParameter types: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println();
        }
    }

    private static void listPrivateConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Private Constructors:");
        for (Constructor<?> constructor : constructors) {
            if ((constructor.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                continue;
            }
            System.out.println("\tName: " + constructor.getName());
            System.out.println("\tParameter types: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println();
        }
    }
}

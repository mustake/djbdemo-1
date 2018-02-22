package com.djb.javademo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  一、获取class 对象
 *  二、获取 对象属性
 *  三、获取对象方法
 *  四、获取构造函数
 *  五、新建类的实例
 *
 */

public class GetClassObject {

    //获取class对象  1.  通过getClass 获取
    public static void getClassMethod(){

        TestReflectOne testReflectOne = new TestReflectOne();
        Class<?> testReflectOneClass=testReflectOne.getClass();
        System.out.println(" ---   getClass()   -----        "+testReflectOneClass);
    }

    //2. 通过  .Class 获取
    public static void pointClass(){
        Class<?> testReflectOneClass=TestReflectOne.class;
        System.out.println(" ---   .class   -----        "+testReflectOneClass);

    }

    //3. 通过 Class.forName
    public static void classForName(){
        try {
            Class<?> testReflectOneClass=Class.forName("com.djb.javademo.reflect.TestReflectOne");
            System.out.println(" ---   Class.forName()  -----        "+testReflectOneClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    // 只能获取 public  的属性   可以通过子类获取父类的属性
    public static void getField(Class<?> classType,String name){
        try {
            Field field= classType.getField(name);
            System.out.println("----  getField() ------"+field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
    // getFields  只能获取 public 的属性 可以通过子类获取父类的属性
    public static void getFields(Class<?> classType){
        Field [] fields=classType.getFields();
        for (Field field:fields) {
            System.out.println("----  getFields() ------"+field);
        }
    }

    // getDeclaredField  可以获取指定 属性 与修饰符无关   只能获取当前类的属性
    public static void getDeclaredField(Class<?> classType,String name){
        try {
           Field field= classType.getDeclaredField(name);
            System.out.println("----  getDeclaredField() ------"+field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    // getDeclaredFields  获取所有属性  与属性的修饰符无关  只能获取当前类的属性
    public static void getDeclaredFields(Class<?> classType){
        Field [] fields=classType.getDeclaredFields();
        for (Field field:fields){
            System.out.println("----  getDeclaredFields() ------"+field);
        }

    }


    // getMethods  获取 子类和父类所有 public 的方法  构造函数不能获取
    public static void getMethod(Class<?> classType){
        Method [] methods= classType.getMethods();
        for (Method method:methods){
            System.out.println("----   getMethods()--------------"+method);
        }
    }

    // getDeclaredMethods  获取 子类的方法 与方法修饰符无关  构造函数不能获取
    public static void getDeclaredMethods(Class<?> classType){
        Method [] methods= classType.getDeclaredMethods();
        for (Method method:methods){
            System.out.println("----   getDeclaredMethods()--------------"+method);
        }
    }


    // getConstructors  获取子类的所有 public  构造函数
    public static void getConstructors(Class<?> classType){
           Constructor<?>[] constructors= classType.getConstructors();
           for (Constructor constructor:constructors){
               System.out.println("------  getConstructors()    ------"+constructor);
           }
    }

    // getConstructor  获取子类的所有 public  构造函数
    public static void getConstructor(Class<?> classType){
        Constructor<?> constructor= null;
        try {
            // 参数表示 构造还是中参数的类型  如果不传，调用无参构造函数
            //constructor = classType.getConstructor(Integer.class);
            constructor = classType.getConstructor(String.class);
            System.out.println("------  getConstructor()    ------"+constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // getDeclaredConstructors 获取子类的所有构造函数  与修饰符无关
    public static void getDeclaredConstructors(Class<?> classType){
        Constructor<?>[] constructors= classType.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.println("------  getDeclaredConstructors()    ------"+constructor);
        }
    }

    /*******************     新建类的实例  *************************/

    //1.通过 class 的 newInstance() 只能调用默认的无参构造函数，如果没有无参构造函数，运行时会报错
    public static Object classNewInstance(Class<?> classType){
        Object instance=null;
        try {
             instance=classType.newInstance();
            System.out.println(instance);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    // 2.通过 constructor 的 newInstance 获取，这个通过获取constructor 可以调用有参数的构造函数
    public static Object constructorNewInstance(Class<?> classType,String publicName){
        Object instance=null;
        try {
            Constructor<?> constructor=classType.getConstructor(String.class );
            instance= constructor.newInstance(publicName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  instance;
    }


    /**************           调用类的函数              ******************/
    //通过反射获取 method 对象，通过 invoke方法调用函数
    public static void fieldInvoke(Class<?> classType,String methodName,String name,Integer age){
        try {
            Object instance=classType.newInstance();
          Method method= classType.getMethod(methodName,String.class,Integer.class);
          method.invoke(instance,name,age);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /***************  设置类的属性值   ******************/

    public static void setClassProperty(Class<?> classType,String propertyName,int publicName){
        try {
            Object instance=classType.newInstance();
            Field field=  classType.getField(propertyName);
            field.setInt(instance,publicName);
            System.out.println(field.getName()+":"+field.get(instance));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//      getClassMethod();
//        pointClass();
//        classForName();
//        getField(TestReflectOne.class,"publicName");
 //       getFields(ExtendsTestReflectOne.class);
//        getDeclaredField(TestReflectOne.class,"privateName");
       // getDeclaredFields(ExtendsTestReflectOne.class);
     //   getMethod(ExtendsTestReflectOne.class);
      //  getDeclaredMethods(ExtendsTestReflectOne.class);
      //  getConstructors(ExtendsTestReflectOne.class);
      //  getConstructor(ExtendsTestReflectOne.class);
       // getDeclaredConstructors(ExtendsTestReflectOne.class);

//      ExtendsTestReflectOne extendsTestReflectOne= (ExtendsTestReflectOne) classNewInstance(ExtendsTestReflectOne.class);
//        extendsTestReflectOne.fromGetClassPrintClassName();
//        ExtendsTestReflectOne.fromThreadPrintClassName();
    //    constructorNewInstance(ExtendsTestReflectOne.class,"你好");
      //  fieldInvoke(ExtendsTestReflectOne.class,"say","名字",20);

       // setClassProperty(ExtendsTestReflectOne.class,"sonAge",20);


    }


}

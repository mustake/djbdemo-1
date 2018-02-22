package com.djb.javademo.reflect;

public class ExtendsTestReflectOne extends TestReflectOne {

    public String sonName;

    public int sonAge;

    // 获取类名  适用于非静态方法
    public  void fromGetClassPrintClassName(){
        System.out.println("------    this.getClass().getName()    ------"+this.getClass().getName());
    }

    //获取类名  使用与静态方法
    public static void fromThreadPrintClassName(){
        System.out.println("--------  Thread.currentThread().getStackTrace()[1].getClassName()    -------"+Thread.currentThread().getStackTrace()[1].getClassName());
    }


    public ExtendsTestReflectOne() {
        System.out.println("--------- ExtendsTestReflectOne   调用无参构造函数      --------");
    }

    public ExtendsTestReflectOne(String sonName) {
        this.sonName = sonName;
        System.out.println("---------ExtendsTestReflectOne    调用有参构造函数  sonName："+this.sonName);
    }

    private ExtendsTestReflectOne(int sonAge){
        this.sonAge=sonAge;
        System.out.println("---------ExtendsTestReflectOne    调用私有有参构造函数  sonAge: "+this.sonAge);
    }

    private void privateMethodSon(){

    }

    void methodSon(){

    }

    protected  void protectedMethodSon(){

    }

    public void publicMethodSon(){

    }

    public void say(String sonName,Integer sonAge){
        System.out.println(" sonName:"+sonName+"     sonAge:"+sonAge);
    }


    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public int getSonAge() {
        return sonAge;
    }

    public void setSonAge(int sonAge) {
        this.sonAge = sonAge;
        System.out.println(" setSonAge:"+this.sonAge);
    }
}

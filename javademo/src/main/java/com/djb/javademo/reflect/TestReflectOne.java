package com.djb.javademo.reflect;

/**
 * 测试反射类 1
 */
public class TestReflectOne {

    private int privateAge;

    private String privateName;

    public String publicName;

    String name;

    protected  String protectedName;

    public int publicAge;


    public TestReflectOne() {
        System.out.println("--------- TestReflectOne   调用无参构造函数      --------");

    }

    public TestReflectOne(String publicName) {
        this.publicName = publicName;
        System.out.println("--------- TestReflectOne   调用有参构造函数   publicName:"+this.publicName);

    }

    private void privateMethodFather(){

    }

    void methodFather(){

    }

    protected  void protectedMethodFather(){

    }


    public int getPrivateAge() {
        return privateAge;
    }

    public void setPrivateAge(int privateAge) {
        this.privateAge = privateAge;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
        System.out.println(" 调用   setPublicName:"+this.publicName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtectedName() {
        return protectedName;
    }

    public void setProtectedName(String protectedName) {
        this.protectedName = protectedName;
    }

    public int getPublicAge() {
        return publicAge;
    }

    public void setPublicAge(int publicAge) {
        this.publicAge = publicAge;
    }
}

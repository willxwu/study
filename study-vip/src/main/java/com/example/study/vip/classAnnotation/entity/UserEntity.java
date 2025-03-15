package com.example.study.vip.classAnnotation.entity;

import com.example.study.vip.classAnnotation.annotation.MyAnnotation;

public class UserEntity {

    private String userName;

    @MyAnnotation
    private Integer userAge;

    public String address;

    public UserEntity() {
        System.out.println("无参构造方法");
    }

    public UserEntity(String userName, Integer userAge,String address) {
        this.userName = userName;
        this.userAge = userAge;
        this.address = address;
        System.out.println("有参构造方法");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "用户名='" + userName + '\'' +
                ", 用户年龄=" + userAge +
                " 地址=" + address;
    }

    @MyAnnotation
    private void say(){
        System.out.println("调用私用方法");
    }


    private void count(String name, Integer b){
        System.out.println("调用有参私用方法："+name+"考了"+b+"分");
    }
}

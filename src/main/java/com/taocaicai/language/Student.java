package com.taocaicai.language;

public class Student {

    private String id;
    private String  username;

    public String sex;


    public String  getName(String id){
        return this.id;
    }
    public void createUser(String id,String usereName){
        this.id=id;
        this.username = usereName;
    }


    public void createUsers(String id,String sex){
        this.id=id;
        this.sex = sex;
    }
}

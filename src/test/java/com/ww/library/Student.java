package com.ww.library;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String sex;
    private String address;
    private String phone;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException{
        password = Integer.valueOf(Integer.valueOf(password).intValue() << 2).toString();
        oos.defaultWriteObject();
    }
    private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        if(password != null)
            password = Integer.valueOf(Integer.valueOf(password).intValue() >> 3).toString();
    }
}

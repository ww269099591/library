package com.ww.library;


import java.io.*;

public class SerilizeTest {
    public static void main(String[] args) {
        serilize();
        Student s = (Student) deserilize();
        System.out.println("姓名：" + s.getName() + "\n年龄：" + s.getAge() + "\n性别：" + s.getSex() + "\n地址：" + s.getAddress() + "\n手机：" + s.getPhone());
    }

    public static Object deserilize() {
        Student s = new Student();
        InputStream is = null;
        ObjectInputStream ois = null;
        File f = new File("/home/ww/Desktop/student.txt");
        try {
            is = new FileInputStream(f);
            ois = new ObjectInputStream(is);
            s = (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }

    public static void serilize() {
        Student s = new Student();
        s.setName("张三");
        s.setAge(32);
        s.setSex("man");
        s.setAddress("北京");
        s.setPhone("12345678910");
        //      s.setPassword("123456");
        OutputStream os = null;
        ObjectOutputStream oos = null;
        File f = new File("/home/ww/Desktop/student.txt");
        try {
            os = new FileOutputStream(f);
            oos = new ObjectOutputStream(os);
            oos.writeObject(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}


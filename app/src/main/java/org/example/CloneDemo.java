package org.example;

import java.util.HashMap;

public class CloneDemo {
    public static void main2(String[] args) {
        User user = new User();
//        user.clone();
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap= new HashMap();
        hashMap.put("name","zhangsan");
        hashMap.put("age","18");

        Object newHashMap = hashMap.clone();
        System.out.println(hashMap == newHashMap);
        System.out.println(hashMap.equals(newHashMap));
    }
}
class User implements Cloneable {
    private String name;
    private int age;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

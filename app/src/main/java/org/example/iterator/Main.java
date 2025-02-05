package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

// 第一种遍历方式：for循环
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + ",");
        }

// 第二种遍历方式：foreach循环
        for (String name : names) {
            System.out.print(name + ",");
        }

// 第三种遍历方式：迭代器遍历
        Iterator<String> iterator = names.iterator();
        iterator.next();
        names.remove("a");
        iterator.next();//抛出ConcurrentModificationException异常
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");//Java中的迭代器接口是第二种定义方式，next()既移动游标又返回数据
        }
    }


    public static void main2(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator = names.iterator();
        iterator.next();
        iterator.remove();
//        iterator.remove(); //报错，抛出IllegalStateException异常
    }


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        names.listIterator();
        iterator1.next();
        iterator1.remove();
        iterator2.next(); // 运行结果？
    }

}

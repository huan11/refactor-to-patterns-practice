
package org.example.composite;

import java.util.ArrayList;
import java.util.List;

// 1. 抽象组件
interface FileSystem {
    void show();
}

// 2. 叶子节点（文件）
class File implements FileSystem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("File: " + name);
    }
}

// 3. 组合节点（文件夹）
class Directory implements FileSystem {
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystem component) {
        children.add(component);
    }

    public void remove(FileSystem component) {
        children.remove(component);
    }

    @Override
    public void show() {
        System.out.println("Directory: " + name);
        for (FileSystem component : children) {
            component.show();
        }
    }
}

// 4. 测试客户端
public class CompositePatternDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Directory subDir = new Directory("subDir");
        File file3 = new File("file3.txt");

        root.add(file1);
        root.add(subDir);
        subDir.add(file3);
        subDir.add(file2);


        root.show();
    }
}

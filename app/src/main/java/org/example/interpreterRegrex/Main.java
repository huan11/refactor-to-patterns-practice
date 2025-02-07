package org.example.interpreterRegrex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // 编译正则表达式，设置大小写不敏感
        // Pattern pattern = Pattern.compile("ADMIN", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("^ADMIN$", Pattern.CASE_INSENSITIVE);

        // 创建匹配器，检查字符串"admin, USER"
        Matcher matcher = pattern.matcher("aadmim, USER");
        // 查找匹配项
        while (matcher.find()) {
            // 打印找到的匹配组
            System.out.println("Has required permission:" + matcher.group());
        }
    }
}

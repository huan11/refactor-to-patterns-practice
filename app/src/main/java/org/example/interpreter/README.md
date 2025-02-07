这个解释器模式的实现主要包含以下几个部分：

解释器模式由以下几部分组成：

1. **抽象表达式（Abstract Expression）**：定义解释器的接口，每种表达式都需要实现该接口。
2. **终结符表达式（Terminal Expression）**：表示基本的、不可再分的语法元素（如数字、变量）。
3. **非终结符表达式（Non-terminal Expression）**：用于组合终结符和其他非终结符的复杂表达式（如加法、乘法）。
4. **上下文（Context）**：存储解释器的外部状态，例如变量的值或计算结果。
5. **客户端（Client）**：构造语法树，并调用解释器解析表达式。



? Context 是什么？解析的上下文



### **1. 主要组件与作用**

| **模式组件**                                  | **Java 文件**                                                | **作用**                                                     |
| --------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **抽象表达式（Expression）**                  | `PermissionExpression.java`                                  | 定义 `interpret(User user)` 方法，所有表达式都需要实现它     |
| **终结符表达式（Terminal Expression）**       | `Permission.java`                                            | 直接表示权限，如 `ADMIN`、`USER`                             |
| **非终结符表达式（Non-terminal Expression）** | `AndExpression.java`、`OrExpression.java`、`NotExpression.java` | 组合多个表达式，形成更复杂的规则（如 `A AND B`、`NOT A`）    |
| **上下文（Context）**                         | `User.java`                                                  | 存储用户的权限信息                                           |
| **客户端（Client）**                          | `Client.java`                                                | 解析权限规则，并对用户进行权限判断                           |
| **表达式解析器**                              | `ExpressionBuilder.java`                                     | 解析字符串表达式（如 `FINANCE_ADMIN OR ADMIN`），并构建相应的表达式树 |


以下是将代码示例与**解释器模式的核心组成部分**对应的表格：

| **组件**                  | **示例代码**                          | **作用** |
|---------------------------|--------------------------------------|----------|
| **抽象表达式（Expression）** | `interface Expression`              | 定义解释器的通用接口，每个表达式都需要实现 `interpret()` 方法 |
| **终结符表达式（Terminal Expression）** | `class NumberExpression` | 代表不可再分的基本元素（数字），直接返回其值 |
| **非终结符表达式（Non-terminal Expression）** | `class AddExpression` 和 `class MultiplyExpression` | 组合终结符或其他非终结符，实现更复杂的计算逻辑（加法、乘法） |
| **上下文（Context）** | **示例代码未显式提供**（可以扩展，如存储变量映射） | 维护解释器的外部状态，如变量值、计算结果等 |
| **客户端（Client）** | `class InterpreterPatternDemo` | 构建语法树并调用 `interpret()` 方法执行表达式计算 |

如果想扩展**上下文（Context）**的应用，可以让它存储变量值，例如解析 `x + y` 这样的表达式。希望这个表格能帮你更直观地理解解释器模式的结构！
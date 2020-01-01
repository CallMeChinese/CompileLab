# 词法分析器

本说明文件应该包含以下内容

+ 实验目的

+ 实验内容

+ 实验方法

+ 实验假设

+ 相关有限自动机的描述

+ 重要数据结构表述

+ 核心算法的描述

+ 测试实例

## 实验目的

完成实验

## 实验内容

通过输入\给定正规表达式，完成一个有限自动机，从而完成语法分析任务

## 实验方法

1. 给定一些正规表达式

2. 将这些正规表达式转化成NFA

3. 将这些NFA合并成一个NFA

4. 将这个NFA化简为DFA

5. 基于DFA完成词法分析任务

实现的符号有：

TODO: 所有的index需要+2，因为要给epsilon and dollar r留下空间

|index  |symbol |token  |
|-------|-------|-------|
|-2     |epsilon|EPSILON|
|-1     |dollarr|DOLLARR|
|0      |{      |lB     |
|1      |}      |rB     |
|2      |[      |lb     |
|3      |]      |rb     |
|4      |(      |lc     |
|5      |)      |rc     |
|6      |>      |gr     |
|7      |<      |ls     |
|8      |>=     |ge     |
|9      |<=     |le     |
|10     |!=     |ne     |
|11     |==     |eq     |
|12     |+      |ad     |
|13     |-      |sb     |
|14     |*      |mt     |
|15     |/      |dv     |
|16     |%      |md     |
|17     |++     |ic     |
|18     |--     |dc     |
|19     |+=     |cad    |
|20     |-=     |csb    |
|21     |*=     |cmt    |
|22     |/=     |cdv    |
|23     |%=     |cmd    |
|24     |&&     |and    |
|25     |\|\|   |or     |
|26     |!      |not    |
|27     |=      |as     |
|28     |^      |bxor   |
|29     |&      |band   |
|30     |\|     |bor    |
|31     |<<     |blm    |
|32     |>>     |brm    |
|33     |[+-]?[0-9]+|INTEGER|
|34     |".*"   |STRING |
|35     |[a-z][a-zA-Z0-9]*|ID     |
|36     |break  |BREAK  |
|37     |case   |CASE   |
|38     |char   |CHAR   |
|39     |continue|CONTINUE|
|40     |default|DEFAULT|
|41     |do     |DO     |
|42     |else   |ELSE   |
|43     |for    |FOR    |
|44     |if     |IF     |
|45     |int    |INT    |
|46     |long   |LONG   |
|47     |main   |MAIN   |
|48     |return |RETURN |
|49     |short  |SHORT  |
|50     |switch |SWITCH |
|51     |unsigned|UNSIGNED|
|52     |while  |WHILE  |
|53     |;      |semicolon|
|54     |".*"   |string |
|55     |,      |comma  |

# 编译原理实验

这是编译原理实验的合集，包含两个实验：词法分析器、语法分析器，详细信息如下

## 词法分析器

本说明文件应该包含以下内容

+ 实验目的

+ 实验内容

+ 实验方法

+ 实验假设

+ 相关有限自动机的描述

+ 重要数据结构表述

+ 核心算法的描述

+ 测试实例

### 实验目的

完成实验

### 实验内容

通过输入\给定正规表达式，完成一个有限自动机，从而完成语法分析任务

### 实验方法

1. 给定一些正规表达式

2. 将这些正规表达式转化成NFA

3. 将这些NFA合并成一个NFA

4. 将这个NFA化简为DFA

5. 基于DFA完成词法分析任务

实现的符号有：

TODO: 所有的index需要+2，因为要给epsilon and dollar r留下空间

|index  |symbol |token  |
|-------|-------|-------|
|0      |epsilon|EPSILON|
|1      |dollarr|DOLLARR|
|2      |{      |lB     |
|3      |}      |rB     |
|4      |[      |lb     |
|5      |]      |rb     |
|6      |(      |lc     |
|7      |)      |rc     |
|8      |>      |gr     |
|9      |<      |ls     |
|10     |>=     |ge     |
|11      |<=     |le     |
|12     |!=     |ne     |
|13     |==     |eq     |
|14     |+      |ad     |
|15     |-      |sb     |
|16     |*      |mt     |
|17     |/      |dv     |
|18     |%      |md     |
|19     |++     |ic     |
|20     |--     |dc     |
|21     |+=     |cad    |
|22     |-=     |csb    |
|23     |*=     |cmt    |
|24     |/=     |cdv    |
|25     |%=     |cmd    |
|26     |&&     |and    |
|27     |\|\|   |or     |
|28     |!      |not    |
|29     |=      |as     |
|30     |^      |bxor   |
|31     |&      |band   |
|32     |\|     |bor    |
|33     |<<     |blm    |
|34     |>>     |brm    |
|35     |[+-]?[0-9]+|INTEGER|
|36     |".*"   |STRING |
|37     |[a-z][a-zA-Z0-9]*|ID     |
|38     |break  |BREAK  |
|39     |case   |CASE   |
|40     |char   |CHAR   |
|41     |continue|CONTINUE|
|42     |default|DEFAULT|
|43     |do     |DO     |
|44     |else   |ELSE   |
|45     |for    |FOR    |
|46     |if     |IF     |
|47     |int    |INT    |
|48     |long   |LONG   |
|49     |main   |MAIN   |
|50     |return |RETURN |
|51     |short  |SHORT  |
|52     |switch |SWITCH |
|53     |unsigned|UNSIGNED|
|54     |while  |WHILE  |
|55     |;      |SEMICOLON|
|56     |".*"   |CHARS |
|57     |,      |COMMA  |

> Tips: 状态36是一个错误状态，在代码运行的过程中不会出现，因为处理代码的时候没有考虑到引号的问题，后来发现问题后用状态56来代替了

### 实验假设

好像没什么假设

### 相关有限自动机的描述

该自动机为一个DFA，检测每一个输入，当输入为在当前状态下完成终结符的某个必要输入时（比如：当前状态为终结符"int"的"in"且输入为't'时），则进入下一个状态，否则，将当前输入段作为ID输出

而该状态机为手动生成

### 重要数据结构表述

```java
// token: use index to tag each token, which will also be used in syntax analyze
public class token {
    public int index;
    public String symbol;

    public token(int index, String symbol) {
        this.index = index;
        this.symbol = symbol;
    }
}
```

```java
// scanner: use left pointer and right pointer to choose lexical unit
public class scanner {
    public int lPoint;
    public int rPoint;
    public String text;

    public scanner(String text) {
        this.lPoint = 0;
        this.rPoint = 0;
        this.text = text;
    }
}
```

### 核心算法的描述

```java
public List<token> scan() {
    List<token> myTokens = new ArrayList<token>();
    int lenth = this.text.length();
    int state = 0;
    while (this.rPoint < lenth) {
        char c = this.text.charAt(this.rPoint);
        switch (state) {
            // TODO: here is the DFA, implement with switch case
        }
    }
    return myTokens;
}
```

### 测试实例

```c
// Input string
int main() {
    int i;
    for (i=0; i<100; i=i+1) {
        int k = 123;
        if (k > 150) {
            k -= i;
        }
        else {
            k += i;
        }
    }
    return 0;
}

```

```shell
# output log
< 47,INT>
< 49,MAIN>
<  6,(>
<  7,)>
<  2,{>
< 47,INT>
< 37,ID>
< 55,;>
< 45,FOR>
<  6,(>
< 37,ID>
< 29,=>
< 35,INTEGER>
< 55,;>
< 37,ID>
<  9,<>
< 35,INTEGER>
< 55,;>
< 37,ID>
< 29,=>
< 37,ID>
< 14,+>
< 35,INTEGER>
<  7,)>
<  2,{>
< 47,INT>
< 37,ID>
< 29,=>
< 35,INTEGER>
< 55,;>
< 46,IF>
<  6,(>
< 37,ID>
<  8,>>
< 35,INTEGER>
<  7,)>
<  2,{>
< 37,ID>
< 22,-=>
< 37,ID>
< 55,;>
<  3,}>
< 44,ELSE>
<  2,{>
< 37,ID>
< 21,+=>
< 37,ID>
< 55,;>
<  3,}>
<  3,}>
< 50,RETURN>
< 35,INTEGER>
< 55,;>
<  3,}>
<  1,DOLLARR>
```

## 语法分析器

本说明文件应该包含以下内容

+ 实验目的

+ 实验内容

+ 实验方法

+ 实验假设

+ 相关有限自动机的描述

+ 重要数据结构表述

+ 核心算法的描述

+ 测试实例

### 实验目的

完成实验

### 实验内容

通过输入语法规则，产生对应的LR(1)预测分析表，并根据预测分析表使用分析器来完成语法分析

### 实验方法

1. 给出一个语法集合，计算每个终结符与非终结符的First与Follow（如果有）

2. 通过1中的计算，推出该语法的LR(1)项集族，以及GOTO关系

3. 根据项集族、GOTO关系计算出预测分析表中的ACTION与GOTO

4. 根据预测分析表来完成语法分析任务

实现的语法集合有

|index|left|right|
|-|----|-----|
|0|s|pro|
|1|pro|decls funcs main|
|2|decls|declf decls|
|3|decls|declv decls|
|4|decls|EPSILON|
|5|declf|type ID ( argv ) ;|
|6|argv|args|
|7|argv|EPSILON|
|8|args|arg , args|
|9|args|arg|
|10|arg|type ID|
|11|declv|type ID ;|
|12|declv|type ID = expr ;|
|13|funcs|func funcs|
|14|funcs|EPSILON|
|15|func|type ID ( argv ) { stmts }|
|16|stmts|stmt stmts|
|17|stmts|EPSILON|
|18|stmt|declv|
|19|stmt|asgn ;|
|20|stmt|loopf|
|21|stmt|loopw|
|22|stmt|seli|
|23|stmt|ret|
|24|asgn|ID = expr|
|25|loopf|FOR ( asgn ; judge ; asgn ) { stmts }|
|26|loopw|WHILE ( judge ) { stmts }|
|27|seli|IF ( judge ) { stmts } ELSE sele|
|28|sele|seli|
|29|sele|{ stmts }|
|30|ret|RETURN expr ;|
|31|expr|term|
|32|expr|term + expr|
|33|expr|term - expr|
|34|term|fact|
|35|term|fact * term|
|36|term|fact / term|
|37|term|fact % term|
|38|fact|( expr )|
|39|fact|value|
|40|value|INTEGER|
|41|value|call|
|42|value|ID|
|43|call|ID ( parav )|
|44|parav|paras|
|45|parav|EPSILON|
|46|paras|para , paras|
|47|paras|para|
|48|para|ID|
|49|para|INTEGER|
|50|para|STRING|
|51|judge|bexpr|
|52|bexpr|bterm|
|53|bexpr|bterm || bexpr|
|54|bterm|bfact|
|55|bterm|bfact && bterm|
|56|bfact|! bfact|
|57|bfact|( bexpr )|
|58|bfact|expr cmpop expr|
|59|main|type MAIN ( ) { stmts }|
|60|type|CHAR|
|61|type|SHORT|
|62|type|INT|
|63|type|LONG|
|64|cmpop|>=|
|65|cmpop|>|
|66|cmpop|<=|
|67|cmpop|<|
|68|cmpop|==|
|69|cmpop|!=|

### 实验假设

+ 在表述语法的过程中，使用小写字母闭包中的元素来表示非终结符，其它（更具体地，是大写字母闭包中的元素以及符号）来表示终结符

+ 在表述语法的过程中，使用A->B的形式表示一条语法，表达式右部的终结符与非终结符用空格间隔开

+ 在表述语法的过程中，将或符号左右的产生式分开表述

+ 实验仅使用部分语法

### 相关有限自动机的描述

由于该自动机是由代码直接生成的，并且自动机的项目实在过多，所以在这里不再列出，表的单元存储在parser中的tableCell中（大约1600项）

### 重要数据结构表述

```java
// expression
public class expression {
    public token lPart;
    public List<token> rPart;
}
```

```java
// item
public class item {
    public expression expr;
    public token prefix;
    int pointer;

    public item(expression expr, token prefix, int pointer) {
        this.expr = expr;
        this.prefix = prefix;
        this.pointer = pointer;
    }
}
```

```java
// group
public class group {
    public List<item> items;
}
```

```java
// edge
public class edge {
    int begIndex;
    int endIndex;
    token switcher;
}
```

```java
/**
 * opt: type of operation, including  
 *      ShiftIn = 0
 *      Reduction = 1
 *      Accept = 2
 *      GOTO = 3
 * optObjIndex: the index of the operating object, correspondingly that
 *      Next state -> Shift in
 *      Index of expression -> Reduction
 *      None -> Accept
 *      Next state -> GOTO
 */
public class operate {
    public int begState;
    public int opt;
    public int optObjIndex;
    public token switcher;

    public operate(int begState, int opt, int optObjIndex, token switcher) {
        this.begState = begState;
        this.opt = opt;
        this.optObjIndex = optObjIndex;
        this.switcher = switcher;
    }

    public String toString() {
        String answer = String.format("%d|%d|%d|%s\n", begState, opt, optObjIndex, switcher.toString());
        return answer;
    }
}
```

### 核心算法的描述

本部分的主要核心算法有3个

1. 计算First与Follow

2. 计算PPT

3. 通过PPT分析token序列

### 测试实例

```c
// Input string
int main() {
    int i;
    for (i=0; i<100; i=i+1) {
        int k = 123;
        if (k > 150) {
            k = k-i;
        }
        else {
            k = k+i;
        }
    }
    return 0;
}

```

```shell
# output log
Reduction with expression: < -3,decls> -> <  0,EPSILON> 
Goto state:2
Reduction with expression: < -4,funcs> -> <  0,EPSILON>
Goto state:10
Shift in token: < 47,INT>, switch to state: 20
Reduction with expression: < -8,type> -> < 47,INT>
Goto state:17
Shift in token: < 49,MAIN>, switch to state: 27
Shift in token: <  6,(>, switch to state: 41
Shift in token: <  7,)>, switch to state: 61
Shift in token: <  2,{>, switch to state: 84
Shift in token: < 47,INT>, switch to state: 8
Reduction with expression: < -8,type> -> < 47,INT>
Goto state:103
Shift in token: < 37,ID>, switch to state: 115
Shift in token: < 55,;>, switch to state: 122
Reduction with expression: < -7,declv> -> < -8,type> < 37,ID> < 55,;> 
Goto state:97
Reduction with expression: <-15,stmt> -> < -7,declv>
Goto state:96
Shift in token: < 45,FOR>, switch to state: 105
Shift in token: <  6,(>, switch to state: 117
Shift in token: < 37,ID>, switch to state: 104
Shift in token: < 29,=>, switch to state: 116
Shift in token: < 35,INTEGER>, switch to state: 38
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:124
Reduction with expression: <-16,asgn> -> < 37,ID> < 29,=> <-12,expr>
Goto state:125
Shift in token: < 55,;>, switch to state: 142
Shift in token: < 37,ID>, switch to state: 138
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:135
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:134
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:133
Reduction with expression: <-12,expr> -> <-23,term> 
Goto state:177
Shift in token: <  9,<>, switch to state: 160
Reduction with expression: <-33,cmpop> -> <  9,<>
Goto state:210
Shift in token: < 35,INTEGER>, switch to state: 238
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:237
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:235
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:234
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:233
Reduction with expression: <-32,bfact> -> <-12,expr> <-33,cmpop> <-12,expr>
Goto state:174
Reduction with expression: <-31,bterm> -> <-32,bfact>
Goto state:173
Reduction with expression: <-30,bexpr> -> <-31,bterm> 
Goto state:172
Reduction with expression: <-21,judge> -> <-30,bexpr>
Goto state:171
Shift in token: < 55,;>, switch to state: 205
Shift in token: < 37,ID>, switch to state: 229
Shift in token: < 29,=>, switch to state: 252
Shift in token: < 37,ID>, switch to state: 59
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:56
Reduction with expression: <-24,fact> -> <-25,value> 
Goto state:54
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:53
Shift in token: < 14,+>, switch to state: 71
Shift in token: < 35,INTEGER>, switch to state: 57
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:56
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:54
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:53
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:86
Reduction with expression: <-12,expr> -> <-23,term> < 14,+> <-12,expr>
Goto state:263
Reduction with expression: <-16,asgn> -> < 37,ID> < 29,=> <-12,expr>
Goto state:228
Shift in token: <  7,)>, switch to state: 251
Shift in token: <  2,{>, switch to state: 262
Shift in token: < 47,INT>, switch to state: 8
Reduction with expression: < -8,type> -> < 47,INT>
Goto state:103
Shift in token: < 37,ID>, switch to state: 115
Shift in token: < 29,=>, switch to state: 123
Shift in token: < 35,INTEGER>, switch to state: 38
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Reduction with expression: <-12,expr> -> <-23,term> 
Goto state:141
Shift in token: < 55,;>, switch to state: 170
Reduction with expression: < -7,declv> -> < -8,type> < 37,ID> < 29,=> <-12,expr> < 55,;>
Goto state:97
Reduction with expression: <-15,stmt> -> < -7,declv>
Goto state:96
Shift in token: < 46,IF>, switch to state: 107
Shift in token: <  6,(>, switch to state: 119
Shift in token: < 37,ID>, switch to state: 138
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:135
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:134
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:133
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:132
Shift in token: <  8,>>, switch to state: 158
Reduction with expression: <-33,cmpop> -> <  8,>>
Goto state:156
Shift in token: < 35,INTEGER>, switch to state: 195
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:194
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:192
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:191
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:190
Reduction with expression: <-32,bfact> -> <-12,expr> <-33,cmpop> <-12,expr>
Goto state:129
Reduction with expression: <-31,bterm> -> <-32,bfact>
Goto state:128
Reduction with expression: <-30,bexpr> -> <-31,bterm> 
Goto state:127
Reduction with expression: <-21,judge> -> <-30,bexpr>
Goto state:139
Shift in token: <  7,)>, switch to state: 169
Shift in token: <  2,{>, switch to state: 204
Shift in token: < 37,ID>, switch to state: 104
Shift in token: < 29,=>, switch to state: 116
Shift in token: < 37,ID>, switch to state: 40
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Shift in token: < 15,->, switch to state: 48
Shift in token: < 37,ID>, switch to state: 40
Reduction with expression: <-25,value> -> < 37,ID> 
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:66
Reduction with expression: <-12,expr> -> <-23,term> < 15,-> <-12,expr>
Goto state:124
Reduction with expression: <-16,asgn> -> < 37,ID> < 29,=> <-12,expr>
Goto state:98
Shift in token: < 55,;>, switch to state: 114
Reduction with expression: <-15,stmt> -> <-16,asgn> < 55,;>
Goto state:96
Reduction with expression: <-14,stmts> -> <  0,EPSILON>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:227
Shift in token: <  3,}>, switch to state: 250
Shift in token: < 44,ELSE>, switch to state: 261
Shift in token: <  2,{>, switch to state: 273
Shift in token: < 37,ID>, switch to state: 104
Shift in token: < 29,=>, switch to state: 116
Shift in token: < 37,ID>, switch to state: 40
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Shift in token: < 14,+>, switch to state: 47
Shift in token: < 37,ID>, switch to state: 40
Reduction with expression: <-25,value> -> < 37,ID>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:65
Reduction with expression: <-12,expr> -> <-23,term> < 14,+> <-12,expr>
Goto state:124
Reduction with expression: <-16,asgn> -> < 37,ID> < 29,=> <-12,expr>
Goto state:98
Shift in token: < 55,;>, switch to state: 114
Reduction with expression: <-15,stmt> -> <-16,asgn> < 55,;>
Goto state:96
Reduction with expression: <-14,stmts> -> <  0,EPSILON>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:276
Shift in token: <  3,}>, switch to state: 278
Reduction with expression: <-22,sele> -> <  2,{> <-14,stmts> <  3,}>
Goto state:271
Reduction with expression: <-19,seli> -> < 46,IF> <  6,(> <-21,judge> <  7,)> <  2,{> <-14,stmts> <  3,}> < 44,ELSE> <-22,sele>
Goto state:101
Reduction with expression: <-15,stmt> -> <-19,seli>
Goto state:96
Reduction with expression: <-14,stmts> -> <  0,EPSILON>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:274
Shift in token: <  3,}>, switch to state: 277
Reduction with expression: <-17,loopf> -> < 45,FOR> <  6,(> <-16,asgn> < 55,;> <-21,judge> < 55,;> <-16,asgn> <  7,)> <  2,{> <-14,stmts> <  3,}>
Goto state:99
Reduction with expression: <-15,stmt> -> <-17,loopf>
Goto state:96
Shift in token: < 50,RETURN>, switch to state: 108
Shift in token: < 35,INTEGER>, switch to state: 38
Reduction with expression: <-25,value> -> < 35,INTEGER>
Goto state:37
Reduction with expression: <-24,fact> -> <-25,value>
Goto state:35
Reduction with expression: <-23,term> -> <-24,fact>
Goto state:34
Reduction with expression: <-12,expr> -> <-23,term>
Goto state:120
Shift in token: < 55,;>, switch to state: 140
Reduction with expression: <-20,ret> -> < 50,RETURN> <-12,expr> < 55,;>
Goto state:102
Reduction with expression: <-15,stmt> -> <-20,ret>
Goto state:96
Reduction with expression: <-14,stmts> -> <  0,EPSILON>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:113
Reduction with expression: <-14,stmts> -> <-15,stmt> <-14,stmts>
Goto state:95
Shift in token: <  3,}>, switch to state: 112
Reduction with expression: < -5,main> -> < -8,type> < 49,MAIN> <  6,(> <  7,)> <  2,{> <-14,stmts> <  3,}>
Goto state:16
Parse success!
```

## 出现的问题与相关的解决办法

在编写词法分析程序的时候，一开始使用的是C++，实际上已经完成了从正则表达式到DFA的转换算法了，但是在测试的过程中出现了一个不可解决的bug（在stl容器方面），当时考虑到python在内存管理方面对于我而言存在了许多的未知性，所以选择了现在的Java开发

在实验的过程中也出现了很多的bug，比如说语法定义的时候少了一个分号，然后在分析的过程中在PPT中找不到对应的跳转项，虽然按理说找不到跳转项就应该认为是报错，但是这样庞大的一个工程有怎么能说自己写的是对的呢？然后一步步分析栈顶状态与读头下的词法单元，发现了语法设计上的漏洞，并及时改正

## 实验感受

说实话，编译原理真的不是常人所能驾驭的，再想到写第一个编译器的人，用的是汇编语言，更加了不起

还是老师上课经常说的“二心”——细心和耐心，再加上自己的对于问题原因的判断，最终才能完成这样的一个实验。不得不说编译原理的实验难度远远超过了以往所有实验难度，在实验的过程中我锻炼了自己分析问题的能力，在错综复杂的现象中找到几个可能的原因并去设计方案解决问题；还有就是调试代码时候的耐心和写代码时候的细心；最终这个实验让我更加了解了编译器中的词法与语法分析器的原理与实现过程，给平时抽象的理论学习形象化。

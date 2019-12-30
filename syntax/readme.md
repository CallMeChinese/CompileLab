# 语法分析器

hello world

废话不多说，直接上语法规则

规定：非终结符标识必须以小写字母开头，终结符标识必须不以小写字母开头，假设不存在左递归

|index|left|->|right|
|-|----|--|-----|
|0|S'||pro|
|1|pro||decls funcs main|
|2|decls||declf decls|
|3|decls||declv decls|
|4|decls||e|
|5|declf||type ID (argv);|
|6|argv||args|
|7|argv||e|
|8|args||arg,args|
|9|args||arg|
|10|arg||type ID|
|11|declv||type ID;|
|12|declv||type ID = expr;|
|13|funcs||func funcs|
|14|funcs||e|
|15|func||type ID(argv) {stmts ret}|
|16|stmts||stmt stmts|
|17|stmts||e|
|18|stmt||asgn|
|19|stmt||loopf|
|20|stmt||loopw|
|21|stmt||seli|
|22|asgn||ID = expr;|
|23|loopf||FOR(asgn; judge; asgn) {stmts}|
|24|loopw||WHILE(judge) {stmts}|
|25|seli||IF (judge) {stmts} ELSE sele|
|26|sele||seli|
|27|sele||{stmts}|
|28|ret||RETURN expr|
|29|expr||term|
|30|expr||term+expr|
|31|expr||term-expr|
|32|term||fact|
|33|term||fact*term|
|34|term||fact/term|
|35|term||fact%term|
|36|fact||(expr)|
|37|fact||value|
|38|value||INTEGER|
|39|value||call|
|40|call||ID(parav)|
|41|parav||paras|
|42|parav||e|
|43|paras||para,paras|
|44|paras||para|
|45|para||ID|
|46|para||INTEGER|
|47|para||STRING|
|48|judge||bexpr|
|49|bexpr||bterm|
|50|bexpr||bterm\|\|bexpr|
|51|bterm||bfact|
|52|bterm||bfact&&bterm|
|53|bfact||!bfact|
|54|bfact||(bexpr)|
|55|bfact||expr cmpop expr|
|56|main||INT MAIN() {stmts ret}|
|57|type||CHAR|
|58|type||SHORT|
|59|type||INT|
|60|type||LONG
|61|cmpop||>=

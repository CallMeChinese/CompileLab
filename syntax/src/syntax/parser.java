package syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import syntax.token;
import syntax.expression;
import syntax.yacc;
import syntax.item;
import syntax.group;
import syntax.operate;

public class parser {
    public List<group> states;
    public List<edge> jumpEdge;
    public List<operate> tableCell;
    public yacc ya;

    public parser() {
        this.ya = new yacc();
        this.states = new ArrayList<group>();
        this.jumpEdge = new ArrayList<edge>();
        this.tableCell = new ArrayList<operate>();
        group initState = new group();
        item initItem = new item(ya.prodExpr.get(0), ya.terSyb.get(1), 0);
        initState.items.add(initItem);
        this.states.add(initState);
    }

    public int Closure(group state) {
        for (int i = 0; i < state.items.size(); ++i) {
            item myItem = state.items.get(i);
            if (myItem.expr.rPart.size() <= myItem.pointer) {
                continue;
            }
            token curToken = myItem.expr.rPart.get(myItem.pointer);
            if (curToken.index >= 0) {
                // TODO: nonTerminal symbol
                continue;
            }
            List<token> tempExpr = myItem.expr.rPart.subList(myItem.pointer+1, myItem.expr.rPart.size());
            // XXX: note that expression in yacc is changed here, should be removed
            tempExpr.add(myItem.prefix);
            List<token> first = ya.First(tempExpr);
            tempExpr.remove(tempExpr.size()-1);
            for (int j = 0; j < ya.prodExpr.size(); ++j) {
                expression expr = ya.prodExpr.get(j);
                boolean isEpsilonExpr = false;
                if (expr.rPart.size() == 1 && expr.rPart.get(0) == ya.terSyb.get(0)) {
                    isEpsilonExpr = true;
                }
                if (expr.lPart == curToken) {
                    for (int k = 0; k < first.size(); ++k) {
                        item nItem = new item(expr, first.get(k), 0);
                        if (isEpsilonExpr) {
                            nItem.pointer = 1;
                        }
                        if (!state.items.contains(nItem)) {
                            state.items.add(nItem);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int Goto(group state, token switcher) {
        group nState = new group();
        int i = 0;
        for (i = 0; i < state.items.size(); ++i) {
            item curItem = state.items.get(i);
            if (curItem.expr.rPart.size() <= curItem.pointer) {
                continue;
            }
            if (curItem.expr.rPart.get(curItem.pointer) == switcher) {
                item nItem = new item(curItem.expr, curItem.prefix, curItem.pointer+1);
                if (!nState.items.contains(nItem)) {
                    nState.items.add(nItem);
                }
            }
        }
        boolean isSubSet = false;
        for (i = 0; i < this.states.size(); ++i) {
            isSubSet = true;
            for (int j = 0; j < nState.items.size(); ++j) {
                if (!this.states.get(i).items.contains(nState.items.get(j))) {
                    isSubSet = false;
                    break;
                }
            }
            if (isSubSet) {
                break;
            }
        }
        if (!isSubSet) {
            this.Closure(nState);
            this.states.add(nState);
            return (this.states.size()-1);
        }
        else {
            return i;
        }
    }

    public int MakeAllGroups() {
        this.Closure(this.states.get(0));
        for (int i = 0; i < this.states.size(); ++i) {
            List<token> switchList = new ArrayList<token>();
            for (int j = 0; j < this.states.get(i).items.size(); ++j) {
                item myItem = this.states.get(i).items.get(j);
                if (myItem.expr.rPart.size() <= myItem.pointer) {
                    continue;
                }
                token switcher = myItem.expr.rPart.get(myItem.pointer);
                if (!switchList.contains(switcher)) {
                    switchList.add(switcher);
                }
            }
            for (int j = 0; j < switchList.size(); ++j) {
                int endIndex = this.Goto(this.states.get(i), switchList.get(j));
                edge nEdge = new edge(i, endIndex, switchList.get(j));
                this.jumpEdge.add(nEdge);
            }
        }
        return 0;
    }

    public int MakePPT() {
        for (int i = 0; i < this.states.size(); ++i) {
            for (int j = 0; j < this.states.get(i).items.size(); ++j) {
                item myItem = this.states.get(i).items.get(j);
                if (myItem.expr.rPart.size() <= myItem.pointer) {
                    int index = 0;
                    for (index = 0; index < ya.prodExpr.size(); ++index) {
                        if (myItem.expr == ya.prodExpr.get(index)) {
                            break;
                        }
                    }
                    operate myOpt = new operate(i, 1, index, myItem.prefix);
                    if (index == 1 && myItem.prefix == this.ya.terSyb.get(1)) {
                        myOpt.opt = 2;
                        System.out.println("Accept from reduction");
                    }
                    this.tableCell.add(myOpt);
                }
            }
        }
        for (int i = 0; i < this.jumpEdge.size(); ++i) {
            operate myOpt = new operate(jumpEdge.get(i).begIndex, 0, jumpEdge.get(i).endIndex, jumpEdge.get(i).switcher);
            if (jumpEdge.get(i).switcher.index < 0) {
                myOpt.opt = 3;
            }
            else {

            }
            this.tableCell.add(myOpt);
        }
        return 0;
    }

    public int parse(List<token> tokenSeq) {
        boolean isAcc = false;
        int index = 0;
        token point = tokenSeq.get(index);
        Stack<token> parseToken = new Stack<token>();
        Stack<Integer> parseState = new Stack<Integer>();
        parseState.push(0);

        while (index < tokenSeq.size()) {
            for (int i = 0; i < this.tableCell.size(); ++i) {
                operate myOpt = this.tableCell.get(i);
                if (myOpt.begState == parseState.peek() &&
                    myOpt.switcher == point) {
                    // TODO: Yeah, we can operate now
                    switch (myOpt.opt) {
                        case 0: {
                            parseState.push(myOpt.optObjIndex);
                            parseToken.push(point);
                            index += 1;
                            point = tokenSeq.get(index);
                            break;
                        }
                        case 1: {
                            expression expr = ya.prodExpr.get(myOpt.optObjIndex);
                            int count = expr.rPart.size();
                            for (int j = 0; j < count; ++j) {
                                if (parseToken.size() > 0) {
                                    parseToken.pop();
                                    parseState.pop();
                                }
                            }
                            for (int j = 0; j < this.tableCell.size(); ++j) {
                                operate tempOpt = this.tableCell.get(j);
                                if (tempOpt.begState == parseState.peek() &&
                                    tempOpt.opt == 3 &&
                                    tempOpt.switcher == expr.lPart) {
                                    parseState.push(tempOpt.optObjIndex);
                                    parseToken.push(expr.lPart);
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Parse success!");
                            isAcc = true;
                            break;
                        }
                        case 3: {
                            System.out.println("Fatal Error: terminal symbol wanted but non-terminal found");
                            break;
                        }
                        default: {
                            System.out.println("Fatal Error: Unknown operation type");
                            break;
                        }
                    }
                    break;
                }
            }
            if (isAcc) {
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        parser pa = new parser();
        pa.MakeAllGroups();
        pa.MakePPT();
        List<token> seq = new ArrayList<token>();
        seq.add(pa.ya.terSyb.get(2));
        seq.add(pa.ya.terSyb.get(2));
        seq.add(pa.ya.terSyb.get(2));
        seq.add(pa.ya.terSyb.get(2));
        seq.add(pa.ya.terSyb.get(3));
        seq.add(pa.ya.terSyb.get(3));
        seq.add(pa.ya.terSyb.get(1));
        pa.parse(seq);
        System.out.println(pa.tableCell.size());
    }
}
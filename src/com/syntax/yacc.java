package com.syntax;

import com.token;
import com.syntax.expression;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class yacc {
    public List<expression> prodExpr;
    public List<token> nonTerSyb;
    public List<token> terSyb;

    public yacc() {
        this.prodExpr = new ArrayList<expression>();
        this.nonTerSyb = new ArrayList<token>();
        this.terSyb = new ArrayList<token>();
        token epsilonToken = new token(0, "EPSILON");
        token rEndToken = new token(1, "DOLLARR");
        this.terSyb.add(epsilonToken);
        this.terSyb.add(rEndToken);
        File file = new File("rule.txt");

        String pattern = "(.*?)->(.*)";
        Pattern r = Pattern.compile(pattern);
        String line = new String();
        try {
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            while ((line = reader.readLine()) != null) {
                String lStrPart = new String();
                String rStrPart = new String();
                Matcher m = r.matcher(line);
                if (m.find()) {
                    expression expr = new expression();
                    boolean haveToken;
                    String[] temp;

                    lStrPart = m.group(1);
                    rStrPart = m.group(2);

                    // TODO: process left side of the expression
                    temp = lStrPart.split(" ");
                    haveToken = false;
                    for (int i = 0; i < this.nonTerSyb.size(); ++i) {
                        if (this.nonTerSyb.get(i).symbol.equals(temp[0])) {
                            haveToken = true;
                            expr.lPart = this.nonTerSyb.get(i);
                            break;
                        }
                    }
                    if (!haveToken) {
                        token nToken = new token(-(this.nonTerSyb.size()+1), temp[0]);
                        expr.lPart = nToken;
                        this.nonTerSyb.add(nToken);
                    }
                    
                    // TODO: process right side of the expression
                    temp = rStrPart.split(" ");
                    for (int i = 0; i < temp.length; ++i) {
                        boolean isNonTerSyb = false;
                        haveToken = false;
                        if (temp[i].charAt(0) >= 'a' && temp[i].charAt(0) <= 'z') {
                            isNonTerSyb = true;
                        }
                        if (isNonTerSyb) {
                            for (int j = 0; j < this.nonTerSyb.size(); ++j) {
                                if (this.nonTerSyb.get(j).symbol.equals(temp[i])) {
                                    haveToken = true;
                                    expr.rPart.add(this.nonTerSyb.get(j));
                                    break;
                                }
                            }
                            if (!haveToken) {
                                token nToken = new token(-(this.nonTerSyb.size()+1), temp[i]);
                                expr.rPart.add(nToken);
                                this.nonTerSyb.add(nToken);
                            }
                        }
                        else {
                            for (int j = 0; j < this.terSyb.size(); ++j) {
                                if (this.terSyb.get(j).symbol.equals(temp[i])) {
                                    haveToken = true;
                                    expr.rPart.add(this.terSyb.get(j));
                                    break;
                                }
                            }
                            if (!haveToken) {
                                token nToken = new token(this.terSyb.size(), temp[i]);
                                expr.rPart.add(nToken);
                                this.terSyb.add(nToken);
                            }
                        }
                    }

                    // TODO: add new expression to expression list
                    this.prodExpr.add(expr);
                }
                else {
                    System.out.println("wrong syntactic rule, maybe cause error");
                }
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public List<token> First(token myToken) {
        List<token> first = new ArrayList<token>();
        if (myToken.index < 0) {
            List<token> tempFirst = new ArrayList<token>();
            for (int i = 0; i < this.prodExpr.size(); ++i) {
                if (this.prodExpr.get(i).lPart.equals(myToken)) {
                    tempFirst = this.First(this.prodExpr.get(i).rPart);
                    for (int j = 0; j < tempFirst.size(); ++j) {
                        if (first.contains(tempFirst.get(j))) {
                            continue;
                        }
                        else {
                            first.add(tempFirst.get(j));
                        }
                    }
                }
            }
        }
        else {
            first.add(myToken);
        }
        return first;
    }

    public List<token> First(List<token> expr) {
        List<token> first = new ArrayList<token>();
        if (expr.size() == 0) {
            first.add(this.terSyb.get(0));
        }
        for (int i = 0; i < expr.size(); ++i) {
            List<token> tempFirst = this.First(expr.get(i));
            boolean haveEpsilon = tempFirst.contains(this.terSyb.get(0));
            for (int j = 0; j < tempFirst.size(); ++j) {
                if (first.contains(tempFirst.get(j))) {
                    continue;
                }
                else {
                    first.add(tempFirst.get(j));
                }
            }
            if (!haveEpsilon) {
                first.remove(this.terSyb.get(0));
                break;
            }
        }
        return first;
    }

    public List<token> Follow(token myToken) {
        List<token> follow = new ArrayList<token>();
        List<token> nonTerList = new ArrayList<token>();
        nonTerList.add(myToken);
        for (int i = 0; i < nonTerList.size(); ++i) {
            if (nonTerList.get(i).equals(this.nonTerSyb.get(1)) && !follow.contains(this.terSyb.get(1))) {
                follow.add(this.terSyb.get(1));
            }
            for (int j = 0; j < this.prodExpr.size(); ++j) {
                boolean haveFound = false;
                List<token> expr = this.prodExpr.get(j).rPart;
                int k;
                for (k = 0; k < expr.size(); ++k) {
                    // XXX: actually "==" can be used here
                    if (expr.get(k).equals(nonTerList.get(i))) {
                        haveFound = true;
                        break;
                    }
                }
                if (haveFound) {
                    expr = expr.subList(k+1, expr.size());
                    List<token> tempFollow = this.First(expr);
                    boolean haveEpsilon = tempFollow.contains(this.terSyb.get(0));
                    if (haveEpsilon) {
                        if (!nonTerList.contains(this.prodExpr.get(j).lPart)) {
                            nonTerList.add(this.prodExpr.get(j).lPart);
                        }
                        tempFollow.remove(this.terSyb.get(0));
                    }
                    for (k = 0; k < tempFollow.size(); ++k) {
                        if (follow.contains(tempFollow.get(k))) {
                            continue;
                        }
                        else {
                            follow.add(tempFollow.get(k));
                        }
                    }
                }
                else {
                    continue;
                }
            }
        }
        return follow;
    }

    
}
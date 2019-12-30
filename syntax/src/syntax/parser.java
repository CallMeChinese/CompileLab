package syntax;

import java.util.ArrayList;
import java.util.List;

import syntax.token;
import syntax.expression;
import syntax.yacc;

public class parser {

    public static void main(String[] args) throws Exception {
        yacc ya = new yacc();
        List<token> myfirst = ya.Follow(ya.nonTerSyb.get(1));
        System.out.println(myfirst.size());
    }
}
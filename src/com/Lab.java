package com;

import com.token;
import com.lexer.lex;
import com.syntax.parser;
import java.util.ArrayList;
import java.util.List;

public class Lab {

    public static void main(String[] args) throws Exception {
        String filePath = "main.c";
        lex myLex = new lex(filePath);
        List<token> tokenSeq = myLex.analyse();
        System.out.println("OK!");
    }
}

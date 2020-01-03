package com;

import com.token;
import com.lexer.lex;
import com.syntax.parser;
import java.util.List;

public class Lab {

    public static void main(String[] args) throws Exception {
        String filePath = "main.c";
        lex myLex = new lex(filePath);
        List<token> tokenSeq = myLex.analyse();
        // for (int i = 0; i < tokenSeq.size(); ++i) {
        //     System.out.println(tokenSeq.get(i).toString());
        // }
        parser myParser = new parser();
        myParser.MakeAllGroups();
        myParser.MakeLRPT();
        myParser.ExportLRPT();
        myParser.parse(tokenSeq);
    }
}

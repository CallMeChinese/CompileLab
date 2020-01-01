package com.lexer;

import com.token;
import com.constoken;
import com.lexer.scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class lex {
    public String filePath;

    public lex(String filePath) {
        this.filePath = filePath;
    }

    public List<token> analyse() throws Exception{
        List<token> myTokens = new ArrayList<token>();
        File file = new File("main.c");
        if (!file.exists()) {
            System.out.println("No such file");
        }
        else {
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            String myText = new String(b);
            fis.close();
            scanner myScanner = new scanner(myText);
            myTokens = myScanner.scan();
            myTokens.add(constoken.terSybList.get(1));
        }
        return myTokens;
    }
}
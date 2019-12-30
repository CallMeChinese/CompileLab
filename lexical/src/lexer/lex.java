package lexer;

import lexer.token;
import lexer.scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class lex {
    public static void main(String[] args) throws Exception {
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
            List<token> myTokens = new ArrayList<token>();
            scanner myScanner = new scanner(myText);
            myTokens = myScanner.scan();
            for (int i = 0; i < myTokens.size(); ++i) {
                System.out.println(myTokens.get(i));
            }
        }
    }
}
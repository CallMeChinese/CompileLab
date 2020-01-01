package com.syntax;

import com.token;
import java.util.List;
import java.util.ArrayList;

public class expression {
    public token lPart;
    public List<token> rPart;

    public expression() {
        this.rPart = new ArrayList<token>();
    }

    public String toString() {
        String answer = new String();
        answer = answer + this.lPart.toString() + " -> ";
        for (int i = 0; i < rPart.size(); ++i) {
            answer += (rPart.get(i).toString() +" ");
        }
        return answer;
    }
}
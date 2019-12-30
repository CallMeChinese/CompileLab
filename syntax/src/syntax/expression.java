package syntax;

import syntax.token;
import java.util.List;
import java.util.ArrayList;

public class expression {
    public token lPart;
    public List<token> rPart;

    public expression() {
        this.rPart = new ArrayList<token>();
    }

    public boolean equals(expression another) {

        return false;
    }
}
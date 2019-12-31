package syntax;

import syntax.token;
import syntax.expression;
import syntax.item;
import java.util.ArrayList;
import java.util.List;

public class group {
    public List<item> items;

    public group() {
        this.items = new ArrayList<item>();
    }
}
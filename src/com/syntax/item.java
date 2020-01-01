package com.syntax;

import com.token;
import com.syntax.expression;

public class item {
    public expression expr;
    public token prefix;
    int pointer;

    public item(expression expr, token prefix, int pointer) {
        this.expr = expr;
        this.prefix = prefix;
        this.pointer = pointer;
    }

    /**
     * @apiNote when all the object in item "==" another, not equals(other)
     * will return true, else return false, which means it should be the 
     * original object from yacc
     * @param another
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof item) {
            item another = (item) obj;
            if (this.expr == another.expr &&
                this.prefix == another.prefix &&
                this.pointer == another.pointer) {
                return true;
            }
        }
        return false;
    }
}
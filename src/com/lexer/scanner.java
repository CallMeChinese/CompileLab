package com.lexer;

import com.token;
import com.constoken;
import java.util.ArrayList;
import java.util.List;

public class scanner {
    public int lPoint;
    public int rPoint;
    public String text;

    public scanner(String text) {
        this.lPoint = 0;
        this.rPoint = 0;
        this.text = text;
    }

    private Boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isLowerChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isUpperChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isChar(char c) {
        if (this.isLowerChar(c) || this.isUpperChar(c)) {
            return true;
        } else {
            return false;
        }
    }

    public List<token> scan() {
        List<token> myTokens = new ArrayList<token>();
        int lenth = this.text.length();
        int state = 0;
        while (this.rPoint < lenth) {
            char c = this.text.charAt(this.rPoint);
            switch (state) {
            case 0: {
                switch (c) {
                case '{':
                    state = 1;
                    break;
                case '}':
                    state = 2;
                    break;
                case '[':
                    state = 3;
                    break;
                case ']':
                    state = 4;
                    break;
                case '(':
                    state = 5;
                    break;
                case ')':
                    state = 6;
                    break;
                case '>':
                    state = 7;
                    break;
                case '<':
                    state = 8;
                    break;
                case '!':
                    state = 9;
                    break;
                case '=':
                    state = 10;
                    break;
                case '+':
                    state = 11;
                    break;
                case '-':
                    state = 12;
                    break;
                case '*':
                    state = 13;
                    break;
                case '/':
                    state = 14;
                    break;
                case '%':
                    state = 15;
                    break;
                case '&':
                    state = 16;
                    break;
                case '|':
                    state = 17;
                    break;
                case '^':
                    state = 18;
                    break;
                case 'b':
                    state = 19;
                    break;
                case 'c':
                    state = 20;
                    break;
                case 'd':
                    state = 21;
                    break;
                case 'e':
                    state = 22;
                    break;
                case 'f':
                    state = 23;
                    break;
                case 'i':
                    state = 24;
                    break;
                case 'l':
                    state = 25;
                    break;
                case 'm':
                    state = 26;
                    break;
                case 'r':
                    state = 27;
                    break;
                case 's':
                    state = 28;
                    break;
                case 'u':
                    state = 29;
                    break;
                case 'w':
                    state = 30;
                    break;
                case ';':
                    state = 111;
                    break;
                case '"':
                    state = 112;
                    break;
                case ',':
                    state = 114;
                    break;
                default: {
                    if (this.isChar(c))
                        state = 31;
                    else if (this.isNumber(c))
                        state = 32;
                }
                }
                this.rPoint += 1;
                if (state == 0) {
                    this.lPoint = this.rPoint;
                } else {

                }
                break;
            }
            case 1: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.LBRACE);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 2: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.RBRACE);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 3: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.LBRACKET);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 4: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.RBRACKET);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 5: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.LCURVE);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 6: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.RCURVE);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 7: {
                switch (c) {
                case '=':
                    state = 33;
                    break; // >=
                case '>':
                    state = 34;
                    break; // >>
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.GREAT);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 8: {
                switch (c) {
                case '=':
                    state = 35;
                    break; // <=
                case '<':
                    state = 36;
                    break; // <<
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.LESS);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 9: {
                switch (c) {
                case '=':
                    state = 37;
                    break; // !=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.NOT);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 10: {
                switch (c) {
                case '=':
                    state = 38;
                    break; // ==
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.ASSIGN);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 11: {
                switch (c) {
                case '+':
                    state = 39;
                    break; // ++
                case '=':
                    state = 40;
                    break; // +=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.ADD);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 12: {
                switch (c) {
                case '-':
                    state = 41;
                    break; // --
                case '=':
                    state = 42;
                    break; // -=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SUB);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 13: {
                switch (c) {
                case '=':
                    state = 43;
                    break; // *=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.MULTI);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 14: {
                switch (c) {
                case '=':
                    state = 44;
                    break; // /=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.DIVIDE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 15: {
                switch (c) {
                case '=':
                    state = 45;
                    break; // %=
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.MOD);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 16: {
                switch (c) {
                case '&':
                    state = 46;
                    break; // &&
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.BAND);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 17: {
                switch (c) {
                case '|':
                    state = 47;
                    break; // ||
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.BOR);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 18: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.BXOR);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 19: {
                switch (c) {
                case 'r':
                    state = 48;
                    break; // br
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 20: {
                switch (c) {
                case 'a':
                    state = 49;
                    break; // ca
                case 'o':
                    state = 50;
                    break; // co
                case 'h':
                    state = 108;
                    break; // ch
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 21: {
                switch (c) {
                case 'e':
                    state = 51;
                    break; // de
                case 'o':
                    state = 52;
                    break; // do
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 22: {
                switch (c) {
                case 'l':
                    state = 53;
                    break; // el
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 23: {
                switch (c) {
                case 'o':
                    state = 54;
                    break; // fo
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 24: {
                switch (c) {
                case 'f':
                    state = 55;
                    break; // if
                case 'n':
                    state = 56;
                    break; // in
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 25: {
                switch (c) {
                case 'o':
                    state = 57;
                    break; // lo
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 26: {
                switch (c) {
                case 'a':
                    state = 58;
                    break; // ma
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 27: {
                switch (c) {
                case 'e':
                    state = 59;
                    break; // re
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 28: {
                switch (c) {
                case 'h':
                    state = 60;
                    break; // sh
                case 'w':
                    state = 61;
                    break; // sw
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 29: {
                switch (c) {
                case 'n':
                    state = 62;
                    break; // un
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 30: {
                switch (c) {
                case 'h':
                    state = 63;
                    break; // wh
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 31: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 32: {
                switch (c) {
                default: {
                    if (this.isNumber(c))
                        state = 32;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(33, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.INTEGER);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 33: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.GREATEQ);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 34: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.BRMOVE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 35: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.LESSEQ);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 36: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.BLMOVE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 37: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.NOTEQ);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 38: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.EQ);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 39: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.INCREASE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 40: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SELFADD);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 41: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.DECREASE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 42: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SELFSUb);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 43: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SELFMULTI);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 44: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SELFDIVIDE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 45: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SELFMOD);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 46: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.AND);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 47: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.OR);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 48: {
                switch (c) {
                case 'e':
                    state = 64;
                    break; // bre
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 49: {
                switch (c) {
                case 's':
                    state = 65;
                    break; // cas
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 50: {
                switch (c) {
                case 'n':
                    state = 66;
                    break; // con
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 51: {
                switch (c) {
                case 'f':
                    state = 67;
                    break; // def
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 52: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.DO);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 53: {
                switch (c) {
                case 's':
                    state = 68;
                    break; // els
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 54: {
                switch (c) {
                case 'r':
                    state = 69;
                    break; // for
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 55: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.IF);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 56: {
                switch (c) {
                case 't':
                    state = 70;
                    break; // int
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 57: {
                switch (c) {
                case 'n':
                    state = 71;
                    break; // lon
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 58: {
                switch (c) {
                case 'i':
                    state = 72;
                    break; // mai
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 59: {
                switch (c) {
                case 't':
                    state = 73;
                    break; // ret
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 60: {
                switch (c) {
                case 'o':
                    state = 74;
                    break; // sho
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 61: {
                switch (c) {
                case 'i':
                    state = 75;
                    break; // swi
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 62: {
                switch (c) {
                case 's':
                    state = 76;
                    break; // uns
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 63: {
                switch (c) {
                case 'i':
                    state = 77;
                    break; // whi
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 64: {
                switch (c) {
                case 'a':
                    state = 78;
                    break; // brea
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 65: {
                switch (c) {
                case 'e':
                    state = 79;
                    break; // case
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 66: {
                switch (c) {
                case 't':
                    state = 80;
                    break; // cont
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 67: {
                switch (c) {
                case 'a':
                    state = 81;
                    break; // defa
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 68: {
                switch (c) {
                case 'e':
                    state = 82;
                    break; // else
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 69: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.FOR);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 70: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.INT);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 71: {
                switch (c) {
                case 'g':
                    state = 83;
                    break; // long
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 72: {
                switch (c) {
                case 'n':
                    state = 84;
                    break; // main
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 73: {
                switch (c) {
                case 'u':
                    state = 85;
                    break; // retu
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 74: {
                switch (c) {
                case 'r':
                    state = 86;
                    break; // shor
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 75: {
                switch (c) {
                case 't':
                    state = 87;
                    break; // swit
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 76: {
                switch (c) {
                case 'i':
                    state = 88;
                    break; // unsi
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 77: {
                switch (c) {
                case 'l':
                    state = 89;
                    break; // whil
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 78: {
                switch (c) {
                case 'k':
                    state = 90;
                    break; // break
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 79: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.CASE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 80: {
                switch (c) {
                case 'i':
                    state = 91;
                    break; // conti
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 81: {
                switch (c) {
                case 'u':
                    state = 92;
                    break; // defau
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 82: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.ELSE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 83: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.LONG);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 84: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.MAIN);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 85: {
                switch (c) {
                case 'r':
                    state = 93;
                    break; // retur
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 86: {
                switch (c) {
                case 't':
                    state = 94;
                    break; // short
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 87: {
                switch (c) {
                case 'c':
                    state = 95;
                    break; // switc
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 88: {
                switch (c) {
                case 'g':
                    state = 96;
                    break; // unsig
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 89: {
                switch (c) {
                case 'e':
                    state = 97;
                    break; // while
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 90: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.BREAK);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 91: {
                switch (c) {
                case 'n':
                    state = 98;
                    break; // contin
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 92: {
                switch (c) {
                case 'l':
                    state = 99;
                    break; // defaul
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 93: {
                switch (c) {
                case 'n':
                    state = 100;
                    break; // return
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 94: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.SHORT);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 95: {
                switch (c) {
                case 'h':
                    state = 101;
                    break; // switch
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 96: {
                switch (c) {
                case 'n':
                    state = 102;
                    break; // unsign
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 97: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.WHILE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 98: {
                switch (c) {
                case 'u':
                    state = 103;
                    break; // continu
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 99: {
                switch (c) {
                case 't':
                    state = 104;
                    break; // default
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 100: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.RETURN);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 101: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.SWITCH);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 102: {
                switch (c) {
                case 'e':
                    state = 105;
                    break; // unsigne
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 103: {
                switch (c) {
                case 'e':
                    state = 106;
                    break; // continue
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 104: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.DEFAULT);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 105: {
                switch (c) {
                case 'd':
                    state = 107;
                    break; // unsigned
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 106: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.CONTINUE);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 107: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.UNSIGNED);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 108: {
                switch (c) {
                case 'a':
                    state = 109;
                    break; // cha
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 109: {
                switch (c) {
                case 'r':
                    state = 110;
                    break; // char
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(35, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.ID);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 110: {
                switch (c) {
                default: {
                    if (this.isChar(c) || this.isNumber(c))
                        state = 31;
                    else
                        state = 0;
                }
                }

                if (state == 0) {
                    myTokens.add(constoken.CHAR);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 111: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.SEMICOLON);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            case 112: {
                switch (c) {
                case '"':
                    state = 113;
                    break;
                default: {
                    state = 112;
                }
                }
                if (state == 0) {
                    String name = this.text.substring(this.lPoint, this.rPoint);
                    token myToken = new token(54, name);
                    myTokens.add(myToken);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 113: {
                switch (c) {
                default: {
                    state = 0;
                }
                }
                if (state == 0) {
                    // String name = this.text.substring(this.lPoint, this.rPoint);
                    // token myToken = new token(54, name);
                    // myTokens.add(myToken);
                    myTokens.add(constoken.CHARS);
                    this.lPoint = this.rPoint;
                } else {
                    this.rPoint += 1;
                }
                break;
            }
            case 114: {
                switch (c) {
                default:
                    state = 0;
                    break;
                }
                if (state == 0) {
                    myTokens.add(constoken.COMMA);
                    this.lPoint = this.rPoint;
                }
                break;
            }
            default: {
                System.out.println("Not finihed");
                break;
            }
            }
        }
        return myTokens;
    }
}
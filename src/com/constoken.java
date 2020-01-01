package com;

import java.util.Arrays;
import java.util.List;
import com.token;

public class constoken {

    public static final token EPSILON = new token(0, "EPSILON");
    public static final token DOLLARR = new token(1, "DOLLARR");
    public static final token LBRACE = new token(2, "{");
    public static final token RBRACE = new token(3, "}");
    public static final token LBRACKET = new token(4, "[");
    public static final token RBRACKET = new token(5, "]");
    public static final token LCURVE = new token(6, "(");
    public static final token RCURVE = new token(7, ")");
    public static final token GREAT = new token(8, ">");
    public static final token LESS = new token(9, "<");
    public static final token GREATEQ = new token(10, ">=");
    public static final token LESSEQ = new token(11, "<=");
    public static final token NOTEQ = new token(12, "!=");
    public static final token EQ = new token(13, "==");
    public static final token ADD = new token(14, "+");
    public static final token SUB = new token(15, "-");
    public static final token MULTI = new token(16, "*");
    public static final token DIVIDE = new token(17, "/");
    public static final token MOD = new token(18, "%");
    public static final token INCREASE = new token(19, "++");
    public static final token DECREASE = new token(20, "--");
    public static final token SELFADD = new token(21, "+=");
    public static final token SELFSUb = new token(22, "-=");
    public static final token SELFMULTI = new token(23, "*=");
    public static final token SELFDIVIDE = new token(24, "/=");
    public static final token SELFMOD = new token(25, "%=");
    public static final token AND = new token(26, "&&");
    public static final token OR = new token(27, "||");
    public static final token NOT = new token(28, "!");
    public static final token ASSIGN = new token(29, "=");
    public static final token BXOR = new token(30, "^");
    public static final token BAND = new token(31, "&");
    public static final token BOR = new token(32, "|");
    public static final token BLMOVE = new token(33, "<<");
    public static final token BRMOVE = new token(34, ">>");
    public static final token INTEGER = new token(35, "INTEGER");
    public static final token STRING = new token(36, "STRING");
    public static final token ID = new token(37, "ID");
    public static final token BREAK = new token(38, "BREAK");
    public static final token CASE = new token(39, "CASE");
    public static final token CHAR = new token(40, "CHAR");
    public static final token CONTINUE = new token(41, "CONTINUE");
    public static final token DEFAULT = new token(42, "DEFAULT");
    public static final token DO = new token(43, "DO");
    public static final token ELSE = new token(44, "ELSE");
    public static final token FOR = new token(45, "FOR");
    public static final token IF = new token(46, "IF");
    public static final token INT = new token(47, "INT");
    public static final token LONG = new token(48, "LONG");
    public static final token MAIN = new token(49, "MAIN");
    public static final token RETURN = new token(50, "RETURN");
    public static final token SHORT = new token(51, "SHORT");
    public static final token SWITCH = new token(52, "SWITCH");
    public static final token UNSIGNED = new token(53, "UNSIGNED");
    public static final token WHILE = new token(54, "WHILE");
    public static final token SEMICOLON = new token(55, ";");
    public static final token CHARS = new token(56, "CHARS");
    public static final token COMMA = new token(57, ",");

    public static final List<token> terSybList = Arrays.asList(
        EPSILON, DOLLARR, LBRACE, RBRACE, LBRACKET, 
        RBRACKET, LCURVE, RCURVE, GREAT, LESS, 
        GREATEQ, LESSEQ, NOTEQ, EQ, ADD, 
        SUB, MULTI, DIVIDE, MOD, INCREASE, 
        DECREASE, SELFADD, SELFSUb, SELFMULTI, SELFDIVIDE, 
        SELFMOD, AND, OR, NOT, ASSIGN, 
        BXOR, BAND, BOR, BLMOVE, BRMOVE, 
        INTEGER, STRING, ID, BREAK, CASE, 
        CHAR, CONTINUE, DEFAULT, DO, ELSE, 
        FOR, IF, INT, LONG, MAIN, 
        RETURN, SHORT, SWITCH, UNSIGNED, WHILE, 
        SEMICOLON, CHARS, COMMA
    );
}
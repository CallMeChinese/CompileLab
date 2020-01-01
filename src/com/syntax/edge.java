package com.syntax;

import com.token;

public class edge {
    int begIndex;
    int endIndex;
    token switcher;

    public edge(int begIndex, int endIndex, token switcher) {
        this.begIndex = begIndex;
        this.endIndex = endIndex;
        this.switcher = switcher;
    }
}
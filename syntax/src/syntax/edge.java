package syntax;

import syntax.token;

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
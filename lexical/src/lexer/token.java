package lexer;

public class token {
    public int index;
    public String symbol;

    public token(int index, String symbol) {
        this.index = index;
        this.symbol = symbol;
    }

    public String toString() {
        return String.format("<%3d,%s>", this.index, this.symbol);
    }
}
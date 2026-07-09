package pieces;

public enum PieceType {
    PAWN("p"),
    KNIGHT("n"),
    BISHOP("b"),
    ROOK("r"),
    QUEEN("q"),
    KING("k");

    private final String symbol;

    PieceType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

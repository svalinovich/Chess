package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Color color;
    private int value;
    private String symbol;
    private boolean moved;
    private ArrayList<String> candidateMoves = new ArrayList<>();
    private Position currentPosition;

    public Piece (Color color, int value, String symbol, Position position) {
        this.color = color;
        this.value = value;
        this.symbol = symbol;
        this.moved = false;
        this.currentPosition = position;
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isMoved() {
        return moved;
    }

    public abstract List<Move> getCandidateMoves(Board board);

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}

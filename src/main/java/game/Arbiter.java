package game;

import board.Board;
import pieces.Color;

public class Arbiter {
    private Board board;
    private Color color;
    private GameState state;

    public Arbiter(Board board, Color color, GameState state) {
        this.board = board;
        this.color = color;
        this.state = state;
    }

    
}

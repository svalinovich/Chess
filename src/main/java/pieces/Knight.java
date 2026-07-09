package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, String symbol, Position position) {
        super(color, 3, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        return List.of();
    }
}

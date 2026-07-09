package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, String symbol, Position position) {
        super(color, 9, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        return List.of();
    }
}

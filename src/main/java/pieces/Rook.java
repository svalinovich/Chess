package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, String symbol, Position position) {
        super(color, 5, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        return List.of();
    }
}

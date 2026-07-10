package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Color color, String symbol, Position position) {
        super(color, Integer.MAX_VALUE, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        ArrayList<Move> candidateMoves = new ArrayList<>();

        for (int row = getCurrentPosition().row() + 1; row >= getCurrentPosition().row() - 1; row--) {
            for (int col = getCurrentPosition().column() - 1; col <= getCurrentPosition().column() + 1; col++) {
                if (row < 0 || col < 0 || row > 7 || col > 7) {
                    continue;
                }

                Piece piece = board.getBoard()[row][col];

                if (row == getCurrentPosition().row() && col == getCurrentPosition().column()) {
                    continue;
                }

                if (piece == null) {
                    candidateMoves.add(new Move(Move.positionToString(new Position(row, col))));
                    continue;
                }

                if (piece.getColor() == getColor()) {
                    continue;
                }

                candidateMoves.add(new Move(Move.positionToString(new Position(row, col))));
            }
        }

        return candidateMoves;
    }
}

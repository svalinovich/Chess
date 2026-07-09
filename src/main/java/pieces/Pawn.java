package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color, String symbol, Position position) {
        super(color, 1, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        List<Move> candidateMoves = new ArrayList<>();
        int row = getCurrentPosition().row();
        int col = getCurrentPosition().column();

        if (!isMoved()) {
            if (getColor() == Color.WHITE && board.getBoard()[row + 2][col] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 2, col))));
            }

            if (getColor() == Color.BLACK && board.getBoard()[row - 2][col] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 2, col))));
            }
        }

        if (getColor() == Color.WHITE) {
            if (board.getBoard()[row + 1][col] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 1, col))));
            }

            if (board.getBoard()[row + 1][col + 1] != null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 1, col + 1))));
            }

            if (board.getBoard()[row + 1][col - 1] != null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 1, col - 1))));
            }
        }

        if (getColor() == Color.BLACK) {
            if (board.getBoard()[row - 1][col] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 1, col))));
            }

            if (board.getBoard()[row - 1][col + 1] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 1, col + 1))));
            }

            if (board.getBoard()[row - 1][col - 1] == null) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 1, col - 1))));
            }
        }

        return candidateMoves;
    }
}

package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, String symbol, Position position) {
        super(color, 3, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        List<Move> candidateMoves = new ArrayList<>();
        int row = getCurrentPosition().row();
        int col = getCurrentPosition().column();

        if (row + 2 < 8 && col + 1 < 8) {
            if (board.getBoard()[row + 2][col + 1] == null || board.getBoard()[row + 2][col + 1].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 2, col + 1))));
            }
        }

        if (row + 2 < 8 && col - 1 >= 0) {
            if (board.getBoard()[row + 2][col - 1] == null || board.getBoard()[row + 2][col - 1].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 2, col - 1))));
            }
        }

        if (row + 1 < 8 && col + 2 < 8) {
            if (board.getBoard()[row + 1][col + 2] == null || board.getBoard()[row + 1][col + 2].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 1, col + 2))));
            }
        }

        if (row + 1 < 8 && col - 2 >= 0) {
            if (board.getBoard()[row + 1][col - 2] == null || board.getBoard()[row + 1][col - 2].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row + 1, col - 2))));
            }
        }

        if (row - 1 >= 0 && col + 2 < 8) {
            if (board.getBoard()[row - 1][col + 2] == null || board.getBoard()[row - 1][col + 2].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 1, col + 2))));
            }
        }

        if (row - 1 >= 0 && col - 2 >= 0) {
            if (board.getBoard()[row - 1][col - 2] == null || board.getBoard()[row - 1][col - 2].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 1, col - 2))));
            }
        }

        if (row - 2 >= 0 && col + 1 < 8) {
            if (board.getBoard()[row - 2][col + 1] == null || board.getBoard()[row - 2][col + 1].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 2, col + 1))));
            }
        }

        if (row - 2 >= 0 && col - 1 >= 0) {
            if (board.getBoard()[row - 2][col - 1] == null || board.getBoard()[row - 2][col - 1].getColor() != getColor()) {
                candidateMoves.add(new Move(Move.positionToString(new Position(row - 2, col - 1))));
            }
        }

        return candidateMoves;
    }
}

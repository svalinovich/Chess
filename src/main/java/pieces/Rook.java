package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, String symbol, Position position) {
        super(color, 5, symbol, position);
    }

    @Override
    public List<Move> getCandidateMoves(Board board) {
        List<Move> candidateMoves = new ArrayList<>();
        int row = getCurrentPosition().row();
        int col = getCurrentPosition().column();

        // right horizontal
        for (int i = 1; col + i < 8; i++) {
            Piece boardPiece = board.getBoard()[row][col + i];
            if (boardPiece != null) {
                if (boardPiece.getColor() != getColor()) {
                    candidateMoves.add(new Move(Move.positionToString(new Position(row, col + i))));
                }

                break;
            }

            candidateMoves.add(new Move(Move.positionToString(new Position(row, col + i))));
        }

        // left horizontal
        for (int i = 1; col - i >= 0; i++) {
            Piece boardPiece = board.getBoard()[row][col - i];
            if (boardPiece != null) {
                if (boardPiece.getColor() != getColor()) {
                    candidateMoves.add(new Move(Move.positionToString(new Position(row, col - i))));
                }

                break;
            }

            candidateMoves.add(new Move(Move.positionToString(new Position(row, col - i))));
        }

        // upper vertical
        for (int i = 1; row + i < 8; i++) {
            Piece boardPiece = board.getBoard()[row + i][col];
            if (boardPiece != null) {
                if (boardPiece.getColor() != getColor()) {
                    candidateMoves.add(new Move(Move.positionToString(new Position(row + i, col))));
                }

                break;
            }

            candidateMoves.add(new Move(Move.positionToString(new Position(row + i, col))));
        }

        // lower vertical
        for (int i = 1; row - i >= 0; i++) {
            Piece boardPiece = board.getBoard()[row - i][col];
            if (boardPiece != null) {
                if (boardPiece.getColor() != getColor()) {
                    candidateMoves.add(new Move(Move.positionToString(new Position(row - i, col))));
                }

                break;
            }

            candidateMoves.add(new Move(Move.positionToString(new Position(row - i, col))));
        }

        return candidateMoves;
    }
}

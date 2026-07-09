package pieces;

import board.Board;
import board.Move;
import board.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, String symbol, Position position) {
        super(color, 9, symbol, position);
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

        // upper-right diagonal
        row = getCurrentPosition().row();
        col = getCurrentPosition().column();
        for (int i = 1; row + i < 8 && col + i < 8; i++) {
            Position position = new Position(row + i, col + i);
            Piece boardPiece = board.getBoard()[row + i][col + i];

            if (boardPiece == null) { // if empty square
                candidateMoves.add(new Move(Move.positionToString(position)));
            }
            else {
                if (boardPiece.getColor() == getColor()) // if friendly piece
                    break;

                candidateMoves.add(new Move(Move.positionToString(position)));
                break;
            }
        }

        // upper-left diagonal
        row = getCurrentPosition().row();
        col = getCurrentPosition().column();
        for (int i = 1; row + i < 8 && col - i >= 0; i++) {
            Position position = new Position(row + i, col - i);
            Piece boardPiece = board.getBoard()[row + i][col - i];

            if (boardPiece == null) { // if empty square
                candidateMoves.add(new Move(Move.positionToString(position)));
            }
            else {
                if (boardPiece.getColor() == getColor()) // if friendly piece
                    break;

                candidateMoves.add(new Move(Move.positionToString(position)));
                break;
            }
        }

        // bottom-right diagonal
        row = getCurrentPosition().row();
        col = getCurrentPosition().column();
        for (int i = 1; row - i >= 0 && col + i < 8; i++) {
            Position position = new Position(row - i, col + i);
            Piece boardPiece = board.getBoard()[row - i][col + i];

            if (boardPiece == null) { // if empty square
                candidateMoves.add(new Move(Move.positionToString(position)));
            }
            else {
                if (boardPiece.getColor() == getColor()) // if friendly piece
                    break;

                candidateMoves.add(new Move(Move.positionToString(position)));
                break;
            }


        }

        // bottom-left diagonal
        row = getCurrentPosition().row();
        col = getCurrentPosition().column();
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            Position position = new Position(row - i, col - i);
            Piece boardPiece = board.getBoard()[row - i][col - i];

            if (boardPiece == null) { // if empty square
                candidateMoves.add(new Move(Move.positionToString(position)));
            }
            else { // if bishop hits a piece
                if (boardPiece.getColor() == getColor()) // if friendly piece
                    break;

                candidateMoves.add(new Move(Move.positionToString(position)));
                break;
            }
        }

        return candidateMoves;
    }
}

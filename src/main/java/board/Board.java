package board;

import pieces.*;

public class Board {
    private final Piece[][] board = new Piece[8][8];

    public void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                switch (row) {
                    case 0:
                        switch (col) {
                            case 0: case 7:
                                board[row][col] = new Rook(Color.WHITE, PieceType.ROOK.getSymbol().toUpperCase(), new Position(row, col));
                                break;
                            case 1: case 6:
                                board[row][col] = new Knight(Color.WHITE, PieceType.KNIGHT.getSymbol().toUpperCase(), new Position(row, col));
                                break;
                            case 2: case 5:
                                board[row][col] = new Bishop(Color.WHITE, PieceType.BISHOP.getSymbol().toUpperCase(), new Position(row, col));
                                break;
                            case 3:
                                board[row][col] = new Queen(Color.WHITE, PieceType.QUEEN.getSymbol().toUpperCase(), new Position(row, col));
                                break;
                            case 4:
                                board[row][col] = new King(Color.WHITE, PieceType.KING.getSymbol().toUpperCase(), new Position(row, col));
                                break;

                        }
                        break;
                    case 1:
                        board[row][col] = new Pawn(Color.WHITE, PieceType.PAWN.getSymbol().toUpperCase(), new Position(row, col));
                        break;
                    case 6:
                        board[row][col] = new Pawn(Color.BLACK, PieceType.PAWN.getSymbol(), new Position(row, col));
                        break;
                    case 7:
                        switch (col) {
                            case 0: case 7:
                                board[row][col] = new Rook(Color.BLACK, PieceType.ROOK.getSymbol(), new Position(row, col));
                                break;
                            case 1: case 6:
                                board[row][col] = new Knight(Color.BLACK, PieceType.KNIGHT.getSymbol(), new Position(row, col));
                                break;
                            case 2: case 5:
                                board[row][col] = new Bishop(Color.BLACK, PieceType.BISHOP.getSymbol(), new Position(row, col));
                                break;
                            case 3:
                                board[row][col] = new Queen(Color.BLACK, PieceType.QUEEN.getSymbol(), new Position(row, col));
                                break;
                            case 4:
                                board[row][col] = new King(Color.BLACK, PieceType.KING.getSymbol(), new Position(row, col));
                                break;
                    }
                    break;
                    default:
                        board[row][col] = null;
                        break;
                }
            }
        }
    }

    public void printBoard() {
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == null) {
                    System.out.print("_ ");
                    continue;
                }

                System.out.print(board[row][col].getSymbol() + " ");
            }

            System.out.println();
        }
    }

    public void makeMove(Move from, Move to) {
        board[to.getBoardPiecePosition().row()][to.getBoardPiecePosition().column()] =
                board[from.getBoardPiecePosition().row()][from.getBoardPiecePosition().column()];
        board[from.getBoardPiecePosition().row()][from.getBoardPiecePosition().column()] = null;
        board[to.getBoardPiecePosition().row()][to.getBoardPiecePosition().column()].setCurrentPosition(
                new Position(to.getBoardPiecePosition().row(), to.getBoardPiecePosition().column())
        );
        board[to.getBoardPiecePosition().row()][to.getBoardPiecePosition().column()].setMoved(true);
    }

    public Piece[][] getBoard() {
        return board;
    }
}

import board.Board;
import board.Move;
import pieces.Piece;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Board board = new Board();
        board.initializeBoard();
        board.printBoard();

        while (true) {
            System.out.print("Player move (from to): ");
            String input = userInput.nextLine().strip();

            if (input.equals("exit")) return;
            if (input.contains("?")) {
                Move move = new Move(input.split(" ")[0]);
                Piece piece = board.getBoard()[move.getBoardPiecePosition().row()][move.getBoardPiecePosition().column()];
                System.out.println("Piece " + piece.getSymbol() + " can make the following moves:");

                List<Move> possibleMoves = piece.getCandidateMoves(board);

                for (Move possibleMove : possibleMoves) {
                    System.out.print(possibleMove.getChessNotation() + " ");
                }

                System.out.println();

                continue;
            }

            String from = input.split(" ")[0];
            String to = input.split(" ")[1];
            board.makeMove(new Move(from), new Move(to));

            board.printBoard();
        }
    }
}

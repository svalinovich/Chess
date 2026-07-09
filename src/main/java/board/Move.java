package board;

import java.util.Map;

public class Move {
    private final String chessNotation;
    private final Position boardPiecePosition;

    public Move(String input) {
        this.chessNotation = input;
        this.boardPiecePosition = convertToPosition(input.strip());
    }

    public static Position convertToPosition(String position) {
        Map<Character, Integer> columns = Map.ofEntries(
                Map.entry('a', 0),
                Map.entry('b', 1),
                Map.entry('c', 2),
                Map.entry('d', 3),
                Map.entry('e', 4),
                Map.entry('f', 5),
                Map.entry('g', 6),
                Map.entry('h', 7)
        );

        return new Position(Character.getNumericValue(position.charAt(1)) - 1, columns.get(position.charAt(0)));
    }

    public static String positionToString(Position position) {
        Map<Integer, Character> columns = Map.ofEntries(
                Map.entry(0, 'a'),
                Map.entry(1, 'b'),
                Map.entry(2, 'c'),
                Map.entry(3, 'd'),
                Map.entry(4, 'e'),
                Map.entry(5, 'f'),
                Map.entry(6, 'g'),
                Map.entry(7, 'h')
        );

        return String.format(columns.get(position.column()) + (Integer.toString(position.row() + 1)));
    }

    public String getChessNotation() {
        return chessNotation;
    }

    public Position getBoardPiecePosition() {
        return boardPiecePosition;
    }
}

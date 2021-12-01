package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Knight extends Piece {

    private static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int position, PieceColor pieceColor) {
        super(position, pieceColor);
    }

    @Override
    public Collection<Move> calculateMoves(ChessBoard board) {
        int candidateDestinationCoordinate;
        List<Move> legalMoves = new ArrayList<>();
        for (int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = this.position + currentCandidate;
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                if (isFirstColumnExclusion(this.position, currentCandidate) ||
                        isSecondColumnExclusion(position, currentCandidate) ||
                        isSeventhColumnExclusion(position, currentCandidate) ||
                        isEightColumnExclusion(position, currentCandidate)) {
                    continue;
                }
                ChessTile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.isOccupied()) {
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    PieceColor pieceColor = pieceAtDestination.getPieceColor();
                    if (this.pieceColor != pieceColor) {
                        legalMoves.add(new AttackingMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }

            }
        }

        return legalMoves;
    }

    private static boolean isFirstColumnExclusion(int position, int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[position] && ((candidateOffset == -17) || (candidateOffset == -10) ||
                candidateOffset == 6 || candidateOffset == 15);

    }

    private static boolean isSecondColumnExclusion(int position, int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[position] && ((candidateOffset == -10) || candidateOffset == 6);
    }

    private static boolean isSeventhColumnExclusion(int position, int candidateOffset) {
        return BoardUtils.SEVENTH_COLUMN[position] && ((candidateOffset == -6) || candidateOffset == 10);

    }

    private static boolean isEightColumnExclusion(int position, int candidateOffset) {
        return BoardUtils.EIGHT_COLUMN[position] && ((candidateOffset == -15) || (candidateOffset == -6) ||
                (candidateOffset == 10) || (candidateOffset == 17));
    }


}

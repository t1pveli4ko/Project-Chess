package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rook extends Piece{

    private static int[] CANDIDATE_MOVE_COORDINATES = {-8, -1, 1, 8};

    public Rook(int position, PieceColor pieceColor) {
        super(position, pieceColor);
    }

    @Override
    public Collection<Move> calculateMoves(ChessBoard board) {
        List<Move> legalMoves = new ArrayList<>();

        for (int candidateOnCoordinatesOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate = this.position;
            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateOnCoordinatesOffset) || isEightColumnExclusion(candidateDestinationCoordinate, candidateOnCoordinatesOffset)) {
                    break;
                }
                candidateDestinationCoordinate += candidateOnCoordinatesOffset;
                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                    ChessTile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    if (!candidateDestinationTile.isOccupied()) {
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    } else {
                        Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        PieceColor pieceColor = pieceAtDestination.getPieceColor();
                        if (this.pieceColor != pieceColor) {
                            legalMoves.add(new AttackingMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }

        return legalMoves;
    }

    private static boolean isFirstColumnExclusion(int currentPosition, int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -1);
    }

    private static boolean isEightColumnExclusion(int currentPosition, int candidateOffset) {
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == 1);
    }
}

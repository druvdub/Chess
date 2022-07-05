package chess;

public class Queen extends Piece{
	// private PieceColour colour;
	// private String symbol;

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			setSymbol("♕");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			setSymbol("♛");
		}
	}

	// public String getSymbol(){
	// 	return symbol;
	// }
	// public PieceColour getColour(){
	// 	return colour;
	// }

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		Piece blockingPiece = Board.getPiece(i1, j1);

		int iDiff = Math.abs(i1 - i0);
		int jDiff = Math.abs(j1 - j0);

		// Check for Diagonal Movement of Queen   (Same as Bishop)
		if ((iDiff == jDiff) && !(iDiff == 0 || jDiff == 0)) {
			if ((i0 > i1) && (j0 > j1)) {
				for (int dist = 1; dist <= iDiff; dist++) {
					if ((i0 - dist) > i1 && (j0 - dist) > j1 ) {
						if (Board.hasPiece(i0 - dist, j0 - dist)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if (((i0 - dist) == i1) && ((j0 - dist) == j1)) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((i0 > i1) && (j0 < j1)) {
				for (int dist = 1; dist <= iDiff; dist++) {
					if ((i0 - dist) > i1 && (j0 + dist) < j1) {
						if (Board.hasPiece(i0 - dist, j0 + dist)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if ((i0 - dist) == i1 && (j0 + dist) == j1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((i0 < i1) && (j0 < j1)) {
				for (int dist = 1; dist <= iDiff; dist++) {
					if ((i0 + dist) < i1 && (j0 + dist) < j1) {
						if (Board.hasPiece(i0 + dist, j0 + dist)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if ((i0 + dist) == i1 && (j0 + dist) == j1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((i0 < i1) && (j0 > j1)) {
				for (int dist = 1; dist <= iDiff; dist++) {
					if ((i0 + dist) < i1 && (j0 - dist) > j1) {
						if (Board.hasPiece(i0 + dist, j0 - dist)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if ((i0 + dist) == i1 && (j0 - dist) == j1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
		}

		// Check for Straight Movement of Queen (Same as Rook)
		else if ((iDiff == 0 || jDiff == 0) && !(iDiff == 0 && jDiff == 0)) {
			if ((i0 > i1) && jDiff == 0) {
				for (int i = i0 - 1; i >= i1; i-- ) {
					if (i > i1) {
						if (Board.hasPiece(i, j0)){
							return false;
						}
						else {
							continue;
						}
					}
					else if (i == i1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((i0 < i1) && jDiff == 0) {
				for (int i = i0 + 1; i <= i1; i++ ) {
					if (i < i1) {
						if (Board.hasPiece(i, j0)){
							return false;
						}
						else {
							continue;
						}
					}
					else if (i == i1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((j0 > j1) && iDiff == 0) {
				for (int j = j0 - 1; j >= j1; j-- ) {
					if (j > j1) {
						if (Board.hasPiece(i0, j)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if (j == j1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
			else if ((j0 < j1) && iDiff == 0) {
				for (int j = j0 + 1; j <= j1; j++ ) {
					if (j < j1) {
						if (Board.hasPiece(i0, j)) {
							return false;
						}
						else {
							continue;
						}
					}
					else if (j == j1) {
						if (Board.hasPiece(i1, j1)) {
							if (this.colour.equals(blockingPiece.getColour())) {
								return false;
							}
							else if (!this.colour.equals(blockingPiece.getColour())) {
								return true;
							}
						}
						else {
							return true;
						}
					}
				}
			}
		}
		else {
			return false;
		}
		return false;
	}
}

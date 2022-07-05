package chess;

public class Bishop extends Piece{
	// private PieceColour colour;
	// private String symbol;

	public Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			setSymbol("♗");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			setSymbol("♝");
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

		// Check valid path for Bishop
		if ((iDiff == jDiff) && !(iDiff == 0 || jDiff == 0)) {
			// Check for different directions i.e., NW, NE, SW, SE
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
		else {
			return false;
		}

		return false;
	}
}

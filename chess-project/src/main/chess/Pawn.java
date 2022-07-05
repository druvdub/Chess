package chess;

public class Pawn extends Piece{
	// private PieceColour colour;
	// private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			setSymbol("♙");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			setSymbol("♟");
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

		if (((i0 == 1 && this.colour == PieceColour.BLACK) || (i0 == 6 && this.colour == PieceColour.WHITE)) && (iDiff != 0)) {
			// First Move and Checking for Double Move is valid or not
			if ((iDiff == 1 || iDiff == 2) && (jDiff == 0)) {
				 if (Board.hasPiece(i1, j1)) {
					 return false;
				 }
				 else if (!(Board.hasPiece(i1, j1))) {
					 return true;
				 }

			}
		}
		else if (((iDiff == 1 && jDiff == 0) || (iDiff == 1 && jDiff == 1)) && (iDiff != 0)) {
			if ((i0 > i1 && this.colour == PieceColour.WHITE) || (i0 < i1 && this.colour == PieceColour.BLACK)) {
				if (jDiff == 0) {
					if (Board.hasPiece(i1, j1)) {
						return false;
					}
					else {
						return true;
					}
				}
				else if (jDiff == 1) {
					if (Board.hasPiece(i1, j1)) {
						if (this.colour.equals(blockingPiece.getColour())) {
							return false;
						}
						else if (!this.colour.equals(blockingPiece.getColour())) {
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

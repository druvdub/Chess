package chess;

public class King extends Piece{
	// private PieceColour colour;
	// private String symbol;

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			setSymbol("♔");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			setSymbol("♚");
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

		// Check valid path for King
		if ((iDiff == 0 && jDiff == 1) || (iDiff == 1 && jDiff == 0) || (iDiff == 1 && jDiff == 1)) {
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
		else {
			return false;
		}

		return false;
	}
}

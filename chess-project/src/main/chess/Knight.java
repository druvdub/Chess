package chess;

public class Knight extends Piece{
	// private PieceColour colour;
	// private String symbol;

 	public Knight(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			setSymbol("♘");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			setSymbol("♞");
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

		if (jDiff == 2 && iDiff == 1 || iDiff == 2 && jDiff == 1) {
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

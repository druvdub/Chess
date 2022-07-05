package chess;

public class CheckInput {

	public static boolean checkCoordinateValidity(String input){

		// Check if Correct length
		if (input.length() != 2) {
			return false;
		}
		else {
			char first = input.charAt(0);
			char second = input.charAt(1);

			// Check if first char is number and second char is letter
			if (!(Character.isDigit(first) && Character.isLetter(second))) {
				return false;
			}
			else {
				// Check if chars are in range
				if (!((Character.getNumericValue(first) <= 8 && Character.getNumericValue(first) >= 1)
				&& (second >= 'a' && second <= 'h'))) {
					return false;
				}
			}
		}
		return true;
	}
}

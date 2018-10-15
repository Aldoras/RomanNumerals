import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {
	// Roman numerals into char/int values
    // I, X, L, V, C, D, M
    // 73, 88, 76, 86 , 67, 68, 77

	public int convertToInteger(String romanNum) {
		// To be Implemented
		if(!romanNumeralsOnly(romanNum)) return -1;
		if(!maximumIXCMRepetition(romanNum)) return -1;
		if(!maximumLVDRepetition(romanNum)) return -1;
		if(!maximumSubtraction(romanNum)) return -1;
		if(!maximumSubtractionPerSameChar(romanNum)) return -1;
		if(!nonSubtractiveLiteralsTesting(romanNum)) return -1;


		return calculateRomanValue(romanNum);

	}

	public int calculateRomanValue(String romanNum) {
		int sum = 0;
		int lastChar = 0;
		for (char c : romanNum.toCharArray()) {
			sum += getIntegerValue(c);
			if(getCharLevel(lastChar) < getCharLevel(c)) sum -= (getIntegerValue((char)lastChar) * 2);
			lastChar = c;
		}
		return sum;
	}



	// Checks the maximum allowed numbers of I,X,C,M letters in string. True if OK,
	// False if it exceeds
	// allowed values;
	public boolean maximumIXCMRepetition(String romanNum) {
		int repetition = 0;
		int lastChar = 0;
		for (char c : romanNum.toCharArray()) {
			if ((c == RomanEnum.I.getNumVal() || c == RomanEnum.X.getNumVal() || c == RomanEnum.C.getNumVal()
					|| c == RomanEnum.M.getNumVal()) && c == lastChar)
				repetition++;
			else
				repetition = 0;
			if (repetition > 2)
				break;
			lastChar = c;
		}
		return repetition < 3;
	}

	// Checks the maximum allowed numbers of L,V,D letters in string. True if OK,
	// False if it exceeds
	// allowed values;
	public boolean maximumLVDRepetition(String romanNum) {
		int lastChar = 0;
		for (char c : romanNum.toCharArray()) {
			if ((c == RomanEnum.L.getNumVal() || c == RomanEnum.V.getNumVal() || c == RomanEnum.D.getNumVal())
					&& c == lastChar)
				return false;
			lastChar = c;
		}
		return true;
	}

	// Tests maximum allowed subtraction of "1" numbers
	// Method expects that the input string is valid RomanNum string
	// including no other letters than IVXLCDM
	public boolean maximumSubtraction(String romanNum) {
		char lastChar = '0';
		//
		for (char c : romanNum.toCharArray()) {
			if (lastChar == RomanEnum.I.getNumVal()) {
				if (getCharLevel(c) - RomanEnum.I.getLevel() > 2)
					return false;
			}
			;
			if (lastChar == RomanEnum.X.getNumVal()) {
				if (getCharLevel(c) - RomanEnum.X.getLevel() > 2)
					return false;
			}
			;
			if (lastChar == RomanEnum.C.getNumVal()) {
				if (getCharLevel(c) - RomanEnum.C.getLevel() > 2)
					return false;
			}
			;
			lastChar = c;
		}
		return true;
	}

	public boolean maximumSubtractionPerSameChar(String romanNum){
		char lastChar = '0';
		int repetition = 0;
		for (char c : romanNum.toCharArray()) {
			if( repetition > 0 &&
			 lastChar != c && 
			 getCharLevel(lastChar) < getCharLevel(c)) return false;
			if(lastChar == c) repetition++;
			else{repetition = 0;}
			

			lastChar = c;
		}
		return true;
	}

	public boolean nonSubtractiveLiteralsTesting(String romanNum){
		char lastChar = '0';
		boolean valid = true;
		for (char c : romanNum.toCharArray()) {
			if(lastChar == RomanEnum.V.getNumVal()) valid = getCharLevel(c) <= RomanEnum.V.getLevel();
			if(lastChar == RomanEnum.L.getNumVal()) valid = getCharLevel(c) <= RomanEnum.L.getLevel();
			if(lastChar == RomanEnum.D.getNumVal()) valid = getCharLevel(c) <= RomanEnum.D.getLevel();
			lastChar = c;
		}
		return valid;
	}

	public boolean romanNumeralsOnly(String romanNum) {
		Pattern regex = Pattern.compile("(?:(?!I|V|X|L|C|D|M)).");
		Matcher m = regex.matcher(romanNum);
		if (m.find()) {
			return false;
		}
		return true;
	}
	//Helper function. 
	private int getCharLevel(int c) {
		 //I=73,    V=86,    X=88,    L=76,    C=67,    D=68,    M=77,
		switch (c) {
		case (int)'I':
			return 1;
		case (int)'V':
			return 2;
		case (int)'X':
			return 3;
		case (int)'L':
			return 4;
		case (int)'C':
			return 5;
		case (int)'D':
			return 6;
		case (int)'M':
			return 7;
		default: return 100;
		}
	}
	private int getIntegerValue(char c) {
		switch (c) {
			case (int)'I':
				return 1;
			case (int)'V':
				return 5;
			case (int)'X':
				return 10;
			case (int)'L':
				return 50;
			case (int)'C':
				return 100;
			case (int)'D':
				return 500;
			case (int)'M':
				return 1000;
			default: return -4000;
			}
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	// The symbols 'I','X','C', and 'M' can be repeated at most 3 times in a row.
	@Test
	public void testMaximumRepetition_XCIIIV() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition("XCIIIV"));
	}

	@Test
	public void testMaximumRepetition_XCIIIIIV() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumIXCMRepetition("XCIIIIIV"));
	}

	@Test
	public void testMaximumRepetition_XXXCIIV() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition("XXXCIIV"));
	}

	@Test
	public void testMaximumRepetition_XXXXCIIV() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumIXCMRepetition("XXXXCIIV"));
	}

	@Test
	public void testMaximumRepetition_CCCII() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition("CCCII"));
	}

	@Test
	public void testMaximumRepetition_CCCCXM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumIXCMRepetition("CCCCXM"));
	}

	@Test
	public void testMaximumRepetition_MMMXX() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition("MMMXX"));
	}

	@Test
	public void testMaximumRepetition_XMMMMX() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumIXCMRepetition("XMMMMX"));
	}

	@Test
	public void testMaximumRepetition_WrongLetters_LLVD() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition("LLVD"));
	}

	@Test
	public void testMaximumRepetition_EmptyString() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumIXCMRepetition(""));
	}

	// The symbols 'V','L', and 'D' can never be repeated.
	@Test
	public void testMaximumLVDRepetition_EmptyString() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumLVDRepetition(""));
	}

	@Test
	public void testMaximumLVDRepetition_WrongLetters_XXCGGHM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumLVDRepetition("XXCGGHM"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneL_LLXC() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumLVDRepetition("LLXC"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneL_LXLILC() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumLVDRepetition("LXLILC"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneV_IIIIVV() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumLVDRepetition("IIIIVV"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneV_XXIIVIVID() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumLVDRepetition("XXIIVIVID"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneD_IIIIDD() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumLVDRepetition("IIIIDD"));
	}

	@Test
	public void testMaximumLVDRepetition_MaxOneD_DXXIIVIVID() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumLVDRepetition("DXXIIVIVID"));
	}

	// The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next
	// highest values ('IV' and
	// 'IX','XL' and 'XC', 'CD' and 'CM').

	@Test
	public void testMaximumSubtraction_IX() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtraction("IX"));
	}

	@Test
	public void testMaximumSubtraction_IC() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumSubtraction("IC"));
	}

	@Test
	public void testMaximumSubtraction_IM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumSubtraction("IM"));
	}

	@Test
	public void testMaximumSubtraction_MXCX() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtraction("MXCX"));
	}

	@Test
	public void testMaximumSubtraction_MXCXM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumSubtraction("MXCXM"));
	}

	@Test
	public void testMaximumSubtraction_Empty() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtraction(""));
	}

	@Test
	public void testMaximumSubtraction_IXCM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtraction("IXCM"));
	}

	@Test
	public void testMaximumSubtraction_DCM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtraction("DCM"));
	}

	// Testing maximul subtraction of the same letter - IIX not possible
	@Test
	public void testMaximumSubtractionOfTheSameLiteral_XXC() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumSubtractionPerSameChar("XXC"));
	}

	@Test
	public void testMaximumSubtractionOfTheSameLiteral_XCCD() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.maximumSubtractionPerSameChar("XCCD"));
	}

	@Test
	public void testMaximumSubtractionOfTheSameLiteral_IVLXCDM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtractionPerSameChar("IVLXCDM"));
	}

	@Test
	public void testMaximumSubtractionOfTheSameLiteral_MMDDCCCLLLXXXVVVIIIII() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.maximumSubtractionPerSameChar("MMDDCCCLLLXXXVVVIIIII"));
	}

	// Testing letter which cannot be subtracted - LCD
	@Test
	public void testNonSubtractiveLiterals_IIVX() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.nonSubtractiveLiteralsTesting("IIVX"));
	}

	@Test
	public void testNonSubtractiveLiterals_LDM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.nonSubtractiveLiteralsTesting("LDM"));
	}

	@Test
	public void testNonSubtractiveLiterals_MDL() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.nonSubtractiveLiteralsTesting("MDL"));
	}

	// Testing whether string contains roman letters only
	@Test
	public void testUsageOfOnlyRomanNumerals_False() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(false, rom.romanNumeralsOnly("IIIVDDDSLLLMLLDX"));
	}

	@Test
	public void testUsageOfOnlyRomanNumerals_True() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(true, rom.romanNumeralsOnly("IIIVDDDLLLMLLDX"));
	}

	// General testing
	@Test
	public void testCalculateRomaValue_MCDXLVII() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(1447, rom.calculateRomanValue("MCDXLVII"));

	}
	@Test
	public void testCalculateRomaValue_Empty() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(0, rom.calculateRomanValue(""));

	}
	@Test
	public void testCalculateRomaValue_MMMM() {
		RomanNumerals rom = new RomanNumerals();
		assertEquals(4000, rom.calculateRomanValue("MMMM"));

	}

	@Test
	public void testConvertToInteger_Empty(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(0, rom.convertToInteger(""));
	}

	@Test
	public void testConvertToInteger_MMMM_4xM(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(-1, rom.convertToInteger("MMMM"));
	}

	@Test
	public void testConvertToInteger_MMMCCCLL_2xL(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(-1, rom.convertToInteger("MMMCCCLL"));
	}

	@Test
	public void testConvertToInteger_IIX_Subtract(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(-1, rom.convertToInteger("IIX"));
	}

	@Test
	public void testConvertToInteger_LC_Subtract(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(-1, rom.convertToInteger("LC"));
	}

	@Test
	public void testConvertToInteger_MMCDXLIX_Valid(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(2449, rom.convertToInteger("MMCDXLIX"));
	}

	@Test
	public void testConvertToInteger_MCMLXXXVIII_Valid(){
		RomanNumerals rom = new RomanNumerals();
		assertEquals(1988, rom.convertToInteger("MCMLXXXVIII"));
	}
}
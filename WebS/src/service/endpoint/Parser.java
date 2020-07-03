package service.endpoint;

import java.util.Hashtable;

public class Parser {
	public static String[] ParserProcess(String text) {
		String textClear = clearTxt(text.toLowerCase());
		return parseString(textClear);
	}
	
	private static String clearTxt(String text) {
		String regex = "[.,!?\\-]";
		String replacement = " ";
		text = text.replaceAll(regex, replacement).replaceAll("  ", " ");
		return text;
	}
	
	private static String[] parseString(String text) {
		String[] parts = text.split(" ");
		return parts;
	}
}

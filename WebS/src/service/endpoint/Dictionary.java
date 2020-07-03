package service.endpoint;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

public class Dictionary {
	private Hashtable<String, List<String>> dictionnary;
	private static Dictionary dictionary;
	
	public Dictionary() throws SQLException {
		dictionnary = InitializeDictionary();
	}
	
	
	public Hashtable<String, List<String>> GetDictionary() {
		return dictionnary;
	}
	
	private Hashtable<String, List<String>> InitializeDictionary() throws SQLException {
		dictionnary = new Hashtable();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(char caract : alphabet) {
			Word word = new Word(String.valueOf(caract));
			dictionnary.put(word.getName(), word.GetWords());
			
		}
		return dictionnary;
		
	}
	
	public static Dictionary getInstance(){
		if(dictionary == null){
			try {
				dictionary = new Dictionary();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } 
		return dictionary;
	}
	
}

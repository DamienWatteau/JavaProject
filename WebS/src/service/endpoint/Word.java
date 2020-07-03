package service.endpoint;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Word {
	private String name;
	private List<String> words;
	
	public Word(String name) throws SQLException {
		this.name = name;
		this.words = InitializeList(name);
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> GetWords(){
		return words;
	}
	
	private List<String> InitializeList(String caract) throws SQLException {
		return BddRequest.getWordsFromBdd(caract);
	}
	
}

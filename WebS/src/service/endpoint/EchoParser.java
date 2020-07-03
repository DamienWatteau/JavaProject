package service.endpoint;

import java.sql.SQLException;
import java.util.List;

public class EchoParser {
	public static int TauxDeConfiance(String[] contentTab) throws SQLException {
    	int occurenceNumber = 0;
    	int confiance = 0;
		Dictionary dictionary = Dictionary.getInstance();
		for (String word : contentTab) {
			List allWord = dictionary.GetDictionary().get(word.substring(0, 1));
			System.out.println("Liste word : "+allWord);
			if(allWord.contains(word)) {
				occurenceNumber+=1;
			}
		}
		if (occurenceNumber> 0 && contentTab.length>0) {
			confiance = (occurenceNumber/contentTab.length)*100;	
		}
		
		System.out.println("Confiance"+confiance);
		return confiance;
    	
    	
    }
    
    public static String[] ParseFileContentDecrypted(String content) {
    	return Parser.ParserProcess(content);
    }
}

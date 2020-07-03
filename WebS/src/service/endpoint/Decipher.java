package service.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.logging.Logger;

@WebService
public class Decipher {
	@WebMethod
	public String SendFile(String [] fileDecrypt){
		Conf conf = new Conf();
//		int confiance= conf.launchProcess(fileDecrypt);
		//String reponse[] = { fileDecrypt[0], fileDecrypt[1], fileDecrypt[2], String.valueOf(confiance)};
		int confiance = 0;
		return String.valueOf(confiance);
	}
}
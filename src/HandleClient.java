import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleClient implements Runnable {

	Socket socket;

	HandleClient(Socket socket){
		this.socket = socket;
	}

	
	public void run() {
		try{
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String cipherMessage, plainMessage;
			int keyValue;
			
			keyValue = Integer.valueOf(in.readLine());
			cipherMessage = String.valueOf(in.readLine());
			plainMessage = decryptData(cipherMessage, keyValue);
			out.println(plainMessage);
			
		}catch(Exception e){
			
		}
	}
	
	public String encryptData (String plainText, int keyShift) {
		String message, encryptedMessage = "";
		int key;
		char ch;
		
		message = plainText;
		
		key = keyShift;
 
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }
	            
	            encryptedMessage += ch;
	        }
	        else {
	        	encryptedMessage += ch;
	        }
		}
		return encryptedMessage;
	}
	
	public static String decryptData (String cipherText, int keyShift) {
		String message, decryptedMessage = "";
		int key;
		char ch;
		
		message = cipherText;
		
		key = keyShift;
 
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch - key);
	            
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }
	            
	            decryptedMessage += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch - key);
	            
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }
	            
	            decryptedMessage += ch;
	        }
	        else {
	        	decryptedMessage += ch;
	        }
		}
		return decryptedMessage;
	}

}

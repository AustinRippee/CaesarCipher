import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException{
		ServerSocket s = new ServerSocket(4000);
		while(true) {
			Socket socket = s.accept();
			HandleClient c = new HandleClient(socket);
			Thread t = new Thread(c);
			t.start();
			s.close();
		}
		
		
	}
	
//	public static void main(String[] args) throws Exception {
//		String cipherMessage, plainMessage;
//		int keyValue;
//		ServerSocket serverSocket = new ServerSocket(6000);
//		
//		System.out.println("------SERVER------");
//		Socket clientSocket = serverSocket.accept();
//		
//		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//		
//		keyValue = Integer.valueOf(in.readLine());
//		cipherMessage = String.valueOf(in.readLine());
//		plainMessage = decryptData(cipherMessage, keyValue);
//		out.println(plainMessage);
//		
//		clientSocket.close();
//		serverSocket.close();
//
//	}
//	
//	public String encryptData (String plainText, int keyShift) {
//		String message, encryptedMessage = "";
//		int key;
//		char ch;
//		
//		message = plainText;
//		
//		key = keyShift;
// 
//		for(int i = 0; i < message.length(); ++i){
//			ch = message.charAt(i);
//			
//			if(ch >= 'a' && ch <= 'z'){
//	            ch = (char)(ch + key);
//	            
//	            if(ch > 'z'){
//	                ch = (char)(ch - 'z' + 'a' - 1);
//	            }
//	            
//	            encryptedMessage += ch;
//	        }
//	        else if(ch >= 'A' && ch <= 'Z'){
//	            ch = (char)(ch + key);
//	            
//	            if(ch > 'Z'){
//	                ch = (char)(ch - 'Z' + 'A' - 1);
//	            }
//	            
//	            encryptedMessage += ch;
//	        }
//	        else {
//	        	encryptedMessage += ch;
//	        }
//		}
//		return encryptedMessage;
//	}
//	
//	public static String decryptData (String cipherText, int keyShift) {
//		String message, decryptedMessage = "";
//		int key;
//		char ch;
//		
//		message = cipherText;
//		
//		key = keyShift;
// 
//		for(int i = 0; i < message.length(); ++i){
//			ch = message.charAt(i);
//			
//			if(ch >= 'a' && ch <= 'z'){
//	            ch = (char)(ch - key);
//	            
//	            if(ch < 'a'){
//	                ch = (char)(ch + 'z' - 'a' + 1);
//	            }
//	            
//	            decryptedMessage += ch;
//	        }
//	        else if(ch >= 'A' && ch <= 'Z'){
//	            ch = (char)(ch - key);
//	            
//	            if(ch < 'A'){
//	                ch = (char)(ch + 'Z' - 'A' + 1);
//	            }
//	            
//	            decryptedMessage += ch;
//	        }
//	        else {
//	        	decryptedMessage += ch;
//	        }
//		}
//		return decryptedMessage;
//	}

}

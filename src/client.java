import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
	
	public static void main(String[] args) throws Exception {
		String plainMessage, cipherMessage, decryptedMessage;
		Scanner sc = new Scanner(System.in);
		
		Socket socket = new Socket("localhost",4000);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		System.out.println("------CLIENT------");
		System.out.println("Enter Message:");
		plainMessage = sc.nextLine();
		System.out.println("Enter Key (# values to swap): ");
		int keyValue = sc.nextInt();
		out.println(keyValue);
		cipherMessage = encryptData(plainMessage, keyValue);
		System.out.println("The Encrypted Text is: " + cipherMessage);
		out.println(cipherMessage);
		
		decryptedMessage = String.valueOf(in.readLine());
		System.out.println("The Decrypted Text is: " + decryptedMessage);
		
		sc.close();
		socket.close();
	}
	
	public static String encryptData (String plainText, int keyShift) {
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
	
	public String decryptData (String cipherText, int keyShift) {
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

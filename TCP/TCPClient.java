import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
public static void main (String args[]) {
// arguments supply message and hostname of destination
	Socket s = null;
	try{ int serverPort = 7896;
	s = new Socket(args[1], serverPort);
	DataInputStream in = new DataInputStream( s.getInputStream());
	DataOutputStream out = new DataOutputStream(
	s.getOutputStream());
	out.writeUTF(args[0]); // UTF is a string encoding
	String data = in.readUTF();
	System.out.println("Received: "+ data) ;
	s.close();
	} 
	catch (UnknownHostException e){
	System.out.println("Sock: "+e.getMessage());
	} 
	catch (EOFException e){System.out.println("EOF: "+e.getMessage());
	} 
	catch (IOException e){System.out.println("IO: "+e.getMessage());}
	 finally {
		 if(s!=null)
		try {s.close();} 
	 catch (IOException e) {}
	 }
}
}
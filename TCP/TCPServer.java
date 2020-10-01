import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main (String args[]) 
	{
	int x=1;
	try{
	int serverPort = 7896;
	ServerSocket listenSocket = new ServerSocket(serverPort);
	System.out.println("SERVER ON");
	while(true) {
	Socket clientSocket = listenSocket.accept();
	Connection c = new Connection(clientSocket);
	
	
	System.out.println("\nPesan ke = " +x+" Berhasil!");
	x++;
	}
	} 
	catch(IOException e) 
	{
	System.out.println("Listen: " +
	e.getMessage());}
	}
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	InetAddress ip;
	String ip2;

	public Connection (Socket aClientSocket)
	{
	try {
	clientSocket = aClientSocket;
	in = new DataInputStream(clientSocket.getInputStream());
	out = new DataOutputStream( clientSocket.getOutputStream());
	ip= clientSocket.getInetAddress();
	ip2= ip.getHostAddress();
	this.start();
	} 
	catch(IOException e) {System.out.println("Connection: "+e.getMessage());}
	}

	public void run()
	{
		try { // an echo server
		String data = in.readUTF();
		out.writeUTF(data);
		System.out.println("Datanya adalah = "+data+ip2);
		
		
		} 
		catch(EOFException e) {
			System.out.println("EOF: "+e.getMessage());
		} 
		catch(IOException e2) {
			System.out.println("IO:s a"+e2.getMessage());}
		
		finally {
			try 
			{clientSocket.close();
			}
			catch (IOException e)
			{
				
			}
			}
	}
}
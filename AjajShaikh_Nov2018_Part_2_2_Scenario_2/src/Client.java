
import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;

public class Client {
	final static int port = 9976;
	
	public static void main(String args[]) throws UnknownHostException,IOException,ClassNotFoundException,SQLException{
		Scanner scn = new Scanner(System.in);
		InetAddress ip = InetAddress.getByName("localhost");
		Socket s =  new Socket(ip,port);
		
		
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		Thread sendMessage = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					String msg = scn.nextLine();
					try {
						dos.writeUTF(msg);
						
					}
					catch(IOException e) {
						e.printStackTrace();
					} 
				}
			}
		});
		
		Thread readMessage = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						String msg=dis.readUTF();
						System.out.println(msg);
					}
					catch(IOException e) {
						e.printStackTrace();
						break;
					}
				}
			}
			
		});
		sendMessage.start();
		readMessage.start();
		
	}
}

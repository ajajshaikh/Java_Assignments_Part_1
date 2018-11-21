import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Server {
	static Vector<ClientHandler> ar = new Vector<>();
	static int i=0;
	
	public static void main(String args[]) throws IOException,ClassNotFoundException{
		ServerSocket ss = new ServerSocket(9976);
		Socket s=null;
		
		while(true) {
			s=ss.accept();
			//Class.forName("com.mysql.jdbc.Driver");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			ClientHandler mtch = new ClientHandler(s,"client "+i,dis,dos);
			Thread t=new Thread(mtch);
			
			System.out.println("Adding this client to active client list"); 
			ar.add(mtch);
			t.start();
			i++;
		}
		
	}
	
}

class ClientHandler implements Runnable {
	Scanner scn =  new Scanner(System.in);
	private String name;
	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s;
	boolean isloggedin;
	//DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	  
	 
	public ClientHandler(Socket s,String name,DataInputStream dis,DataOutputStream dos) {
		this.s=s;
		this.name=name;
		this.dis=dis;
		this.dos=dos;
		this.isloggedin=true;
	}
	
	
	@Override
	public void run() {
		String received;
		try {
		String url = "jdbc:mysql://localhost:3306/chat_history";
		String uname = "root";
		String pass = "";
		String toreturn;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =  DriverManager.getConnection(url,uname,pass);
		Statement stmt = con.createStatement();
		
		while(true) {
			try {
				received=dis.readUTF();
				if(received.equals("logout")) {
					this.isloggedin = false;
					this.s.close();
					break;
				}
				//StringTokenizer st = new StringTokenizer(received, "@");
				//String MsgToSend = st.nextToken();
				//String recipent = st.nextToken();
				String MsgToSend =received;
				toreturn = dtf.format(now);
				//stmt.executeUpdate("insert into chat_backup_broadcast values(\"" + recipent + "\",\"" + MsgToSend + "\")");
				stmt.executeUpdate("insert into chat_backup_broadcast values('time' , \"" + toreturn + "\" )");
				stmt.executeUpdate("insert into chat_backup_broadcast values('msg' , \"" + MsgToSend + "\" )");
				con.close();
				
				
				for(ClientHandler mc : Server.ar) {
					/*if(mc.name.equals(recipent) && mc.isloggedin==true) {
						mc.dos.writeUTF(this.name+" : "+MsgToSend);
						*/
					//if(!mc.name.equals(recipent) && mc.isloggedin==true) {
					if(mc.isloggedin==true) {
						mc.dos.writeUTF(toreturn);
						mc.dos.writeUTF(this.name+" : "+MsgToSend);
					}
				}
			}
			catch(IOException e) {
					e.printStackTrace();
			}
		}
		try {
			this.dis.close();
			this.dos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}

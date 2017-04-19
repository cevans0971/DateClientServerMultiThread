import java.net.*;
import java.io.*;
public class DateServer implements Runnable 
{
	Socket dsocket;
	DateServer(Socket sock)
	{
		dsocket = sock;
	}
public static void main(String[] args) throws Exception {

ServerSocket sock = new ServerSocket(6013);
// now listen for connections
while (true) {
Socket client = sock.accept();
Thread thread  =new Thread(new DateServer(client));
thread.start();
}
}





@Override
public void run() {
	// TODO Auto-generated method stub
	try 
	{
	PrintWriter pout = new
			PrintWriter(dsocket.getOutputStream(), true);
			// write the Date to the socket
			pout.println(new java.util.Date().toString());
			// close the socket and resume
			// listening for connections
			pout.close();
			dsocket.close();
			}
			
			catch (IOException ioe) {
			System.err.println(ioe);
			}
			}
	
}


import java.net.*; // Program for a Client
import java.io.*;

public class Client
{
	// it initialize the socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
	private DataOutputStream out	 = null;

	
	public Client(String address, int port) // constructor to put ip address and port
	{
		// it establish a connection
		try 
		{
			socket = new Socket(address, port);
			System.out.println("Connected");

			// it takes input from the terminal
			input = new DataInputStream(System.in);

			// it sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		//the string to read message from input
		String line = "";

		// it keep reading until "Over" is input
		while (!line.equals("Over"))
		{
			try
			{
				line = input.readLine();
				out.writeUTF(line);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}

		// it will close the connection
		try
		{
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		Client client = new Client("127.0.0.1", 5000);
	}
}


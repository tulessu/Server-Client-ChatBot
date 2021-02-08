
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clients {
	public static void main(String[] args) throws IOException, UnknownHostException { 
		String name = args[0];//name for the client
		

		Socket socket = new Socket("127.0.0.1", 4568);//local host and port num that server will listen
		PrintWriter prWriter = new PrintWriter(socket.getOutputStream(), true);//to send messages to the server
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//get input from client
		BufferedReader bufferedReadercmd = new java.io.BufferedReader(new InputStreamReader(System.in));//get input from cmd prompt
		while (true) {

			String line = bufferedReadercmd.readLine();//to read the clients input
			prWriter.println(line);//prints clients input
			System.out.println(bufferedReader.readLine());
		/*	if (line.equals("I have products if you have fares.")) { //if users input is this line
				prWriter.println("I want potion.");                  //then print this line to server
			}
			if (line.equals("Potions are for losers.")) {
				prWriter.println("I want a dagger.");
			}
			if (line.equals("You can have it.")) {
				prWriter.println("I want dragon eggs.");
			}
			if (line.equals("Dragon eggs are for losers.")) {
				prWriter.println("Ops.");
			}
			if (line.equals("Have a nice day.")) {
				prWriter.println("Thanks.");
			}*/
		}

	
	}

}




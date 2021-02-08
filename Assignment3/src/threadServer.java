import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class threadServer extends Thread {
	Socket socket;

	threadServer(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		String message = null;
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//to get what client writes 
			PrintWriter prWriter = new PrintWriter (socket.getOutputStream(),true);//allows to forward the message to client back
			//OutputStream out = socket.getOutputStream();
			//DataOutputStream dout = new DataOutputStream(out);
			while ((message = bufferedReader.readLine()) != null) {//keeps reading until client stops writing a message
				System.out.println("Message from client : " + message);
				
				
				if (message.equals("Potions are for losers.")) { //if the input is this then print next line to the client 
					message="I want a dagger.";
				
				}
				if (message.equals("I have products if you have fares.")) {
					message="I want potion.";
				
				}
				if (message.equals("You can have it.")) {
					message="I want dragon eggs.";
				
				}
				if (message.equals("Dragon eggs are for losers.")) {
					message="Ops.";
				
				}
				if (message.equals("Have a nice day.")) {
					message="Thanks.";
				
				}
				prWriter.println("Forwarding other client's message from server "+message);//forwards the input to the client 
				//dout.writeUTF("message is " +message);
				
			}
			socket.close();
		} catch (Exception e) {

		}
	}
}

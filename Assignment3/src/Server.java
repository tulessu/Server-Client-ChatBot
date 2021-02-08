import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static final int PORT = 4568; //port num which server will listen to

	
	public void runServer() throws IOException,UnknownHostException {
		ServerSocket serverSocket = new ServerSocket(PORT); 
		System.out.println("Server is ready for a client"); 
		while (true) {
			Socket socket = serverSocket.accept();//accepts the connections and waits for a client 
			new threadServer(socket).start();//then starts the threadServer run method
		}
	}
	public static void main(String[] args) throws IOException, UnknownHostException {
		new Server().runServer();//executes runServer method

	}
}

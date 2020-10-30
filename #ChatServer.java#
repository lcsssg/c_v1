import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
	ServerSocket serverSocket
	    = new ServerSocket(Integer.parseInt(args[0]));

	ArrayList<String> history = new ArrayList<>();
	
	System.out.println("Server's port is: " + args[0]);

	while (true) {
	    Socket client = serverSocket.accept();

	    InputStreamReader isr                  
		= new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8);

	    BufferedReader reader = new BufferedReader(isr);
	    PrintWriter output = new PrintWriter(client.getOutputStream());

	    output.println(history.size() + 1);
	    output.println("Welcome to the chat!");
	    output.flush();

	    for (String message : history) {
		output.println(message);    
	    }
	    output.flush();
	    while (! reader.ready());
		
	    String line;
	    while((line = reader.readLine())!= null) {
	    if (line.equals(".")){
		break;

	    }
	    Date d = new Date();
	    history.add(d + ": " + line);

	}

    }
}

}

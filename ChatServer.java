import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {

	while (true) {
	    ServerSocket serverSocket
	    = new ServerSocket(Integer.parseInt(args[0]));

	   ArrayList<String> history = new ArrayList<>();

	    System.out.println("Server's port is: " + args[0]);
	    String line;


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
	
	    while((line = reader.readLine())!= null) {
	    	System.out.println("someone wrote the message");
	    Date d = new Date();
	    history.add(d + ": " + line);
}
	}

    }
}
}
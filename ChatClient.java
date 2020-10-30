import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
	Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
	String nickname = args[2];

	BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

	BufferedReader serverInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	PrintWriter output = new PrintWriter(socket.getOutputStream());

	String line = serverInputReader.readLine();
	int messageCount = Integer.parseInt(line);
	for (int i = 0; i < messageCount; i++) {
	    System.out.println( serverInputReader.readLine() );
	}
        while((line = inputReader.readLine())!= null) {
	    if (line.equals(".")) {
		break;
	    }
	    output.println(nickname + ": " + line);
	}
	output.println(".");
	output.flush();
	socket.close();
    }
}

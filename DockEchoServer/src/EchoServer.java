import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;


public class EchoServer {
	static InputStream input;
	static OutputStream output;
	static BufferedReader Binput;
	static BufferedWriter Boutput;
	
	static ServerSocket serverSocket;
	static Socket socket;
	
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(10090);
			while(true) {
				socket = serverSocket.accept();
				System.out.println("소켓 들어옴");
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				
				Binput = new BufferedReader(new InputStreamReader(input));
				Boutput = new BufferedWriter(new OutputStreamWriter(output));
				String inanswer = Binput.readLine();
				System.out.println(inanswer);
				Boutput.write(inanswer);
				Boutput.flush();
				
				if(Boutput != null) {
					Boutput.close();
				}
				if(Binput != null) {
					Binput.close();
				}
				if(output != null) {
					output.close();
				}
				if(input != null) {
					input.close();
				}
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class EchoClient {
	static InputStream input;
	static OutputStream output;
	static BufferedReader Binput;
	static BufferedWriter Boutput;
	static BufferedReader iinput;
	static Socket socket;
	
	public static void main(String[] args) {
		while(true) {
			iinput = new BufferedReader(new InputStreamReader(System.in));
			Socket socket = null;
			int port = 10090;
			String ip = "211.199.232.197:10090";
			System.out.print("에코 시작.>> ");
			try {
				socket = new Socket(ip, port);
				input = socket.getInputStream();
				output = socket.getOutputStream();

				try {
					String msg;
					String returnmsg;
					System.out.print("전송할 메세지를 입력 >> ");
					msg = iinput.readLine();
					System.out.println(msg);
					Binput = new BufferedReader(new InputStreamReader(input));

					Boutput = new BufferedWriter(new OutputStreamWriter(output));

					Boutput.write(msg+'\n');
					Boutput.flush();

					returnmsg = Binput.readLine();
					System.out.println(returnmsg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			if(Boutput != null) {
				try {
					Boutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(Binput != null) {
				try {
					Binput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}

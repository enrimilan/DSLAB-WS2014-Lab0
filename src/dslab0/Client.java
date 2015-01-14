package dslab0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final String host = "stockholm.vitalab.tuwien.ac.at";
	private static final int port = 9000;
	private static final String immatriculationNumber = "xxxxxxx";
	private static final String numericTUWELUserId = "xxxxx";

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + host);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + host);
			System.exit(1);
		}
		
		out.println("!login "+immatriculationNumber + " " + numericTUWELUserId);
		String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }
		out.close();
		in.close();
		socket.close();
	}
}
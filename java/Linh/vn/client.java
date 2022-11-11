package Linh.vn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException  {
	Socket socket =  new Socket("localhost", 7);
	DataOutputStream t = new DataOutputStream(socket.getOutputStream());
	DataInputStream di=new DataInputStream(socket.getInputStream());
		while(true) {
		
		Scanner sc = new Scanner(System.in);
		// ket noi server
		System.out.println("Connected:" + socket);
		
			String mes =sc.nextLine();
			t.writeUTF(mes);
			t.flush();
			if (mes.equals("close")) {
				break;
			}
			String r = di.readUTF();
			System.out.println(r);
			
		}
	}
}
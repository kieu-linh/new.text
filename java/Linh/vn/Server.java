package Linh.vn;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(7);
		Socket socket=serverSocket.accept();
		while(true) {
			DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
			DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
			
			String r=dataInputStream.readUTF();
			if(r.equals("close")) {
				break;
			}
			System.out.println(r);
			
			Scanner sc=new Scanner(System.in);
			String mess=sc.nextLine();
			dataOutputStream.writeUTF(mess);
			dataOutputStream.flush();
		}
		System.out.println("Close");
	}
}
package Linh.vn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {
	public final static String SERVER_IP = "192.168.14.61";
	public final static int SERVER_PORT = 7;
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		try {
			socket = new Socket (SERVER_IP,SERVER_PORT);
			System.out.println("----Ho Thi Kieu Linh 20CNTT1-----");
			System.out.print("Connected: "+socket);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			for(int i='0';i<='9';i++) {
				os.write(i);
				int ch = is.read();
				System.out.print((char) ch + " ");
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.print("Can't connect to server!");
		}finally {
			if(socket!=null) {
				socket.close();
			}
		}
		
	}

}

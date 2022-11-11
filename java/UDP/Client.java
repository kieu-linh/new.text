package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket=new DatagramSocket();
		String m="Hello";
		byte []bs=m.getBytes();
		InetAddress inetAddress=InetAddress.getByName("localhost");
		DatagramPacket datagramPacket= new DatagramPacket(bs, bs.length, inetAddress, 123);
		datagramSocket.send(datagramPacket);
		
		byte []b=new byte[2048];
		DatagramPacket datagramPacket2=new DatagramPacket(b, b.length);
		datagramSocket.receive(datagramPacket2);
		String receive=new String(datagramPacket2.getData());
		System.out.println(receive);
	}
}

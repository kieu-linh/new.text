package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket=new DatagramSocket(123);
		byte [] bs=new byte[2048];
		DatagramPacket datagramPacket=new DatagramPacket(bs, bs.length);
		datagramSocket.receive(datagramPacket);
		
		String mess=new String(datagramPacket.getData());
		System.out.println(mess);
		
		String sendString="Hello client";
		byte []send=sendString.getBytes();
		DatagramPacket datagramPacket2=new DatagramPacket(send, send.length, datagramPacket.getAddress(), datagramPacket.getPort());
		datagramSocket.send(datagramPacket2);
	}
}

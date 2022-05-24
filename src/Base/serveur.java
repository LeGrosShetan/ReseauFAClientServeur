package Base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class serveur {
	public static void main(String args[]) throws IOException{
		DatagramSocket ds = new DatagramSocket(1084);
		byte[] buffer = new byte[256];
		DatagramPacket dp = new DatagramPacket(buffer, 256);
		
		ds.receive(dp);
		
		int         packetPort   = dp.getPort();
		InetAddress packetAdress = dp.getAddress();
		byte[]      packetData   = dp.getData();
		
		String    received  = new String(packetData, StandardCharsets.US_ASCII);
		String [] message   = received.split("/");
		System.out.println(message[0]);
		
		Comm c1 = new Comm(packetAdress, 2000);
		c1.start();
		/*(new Comm(packetAdress,packetPort)).start();*/
	}
}

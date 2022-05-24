package Base;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class client {
	
	public static void main (String args[]) throws IOException{
		DatagramSocket ds      = new DatagramSocket();
		
		String         message = "Hello everybody, my name is Markiplier/";
		byte[]         buffer  = message.getBytes(StandardCharsets.US_ASCII);
		
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 1084);
		ds.send(dp);
		
		ds = new DatagramSocket(1084);
		buffer = new byte[256];
		dp = new DatagramPacket(buffer, 256);
		
		ds.receive(dp);
		
		byte[]      packetData   = dp.getData();
				
		String    received  = new String(packetData, StandardCharsets.US_ASCII);
		message  = received.split("/")[0];
		
	System.out.println("ZIZICAZ");
	}
}

package Base;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class client {
	
	public static void main (String args[]) throws IOException{
		DatagramSocket ds      = new DatagramSocket();
		
		Scanner scanner = new Scanner(System.in);

        System.out.println("Envoi du message: ");

        String message = scanner.next();
        
        scanner.close();
        
		byte[]         buffer  = message.getBytes(StandardCharsets.US_ASCII);
		
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 1084);
		ds.send(dp);
		
		ds = new DatagramSocket(1085);
		buffer = new byte[256];
		dp = new DatagramPacket(buffer, 256);
		
		ds.receive(dp);
		
		byte[]      packetData   = dp.getData();
		int         packetPort   = dp.getPort();
		InetAddress packetAdress = dp.getAddress();
				
		String    received  = new String(packetData, StandardCharsets.US_ASCII);
		message  = received.split("/")[0];
		
		System.out.println(message + " -> " + packetAdress + ":" + packetPort);
	}
}

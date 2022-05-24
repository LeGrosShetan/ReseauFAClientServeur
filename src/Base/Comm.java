package Base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Comm extends Thread{
	private InetAddress ipClient;
	private int portClient;
	
	public Comm(InetAddress ip, int port) {
		this.ipClient = ip;
		this.portClient = port;
	}
	
	public void run(){
		
		try {
			DatagramSocket ds = new DatagramSocket();
			
			System.out.println("Nouveau Client : " + this.ipClient + ":" + this.portClient);
			
			String         message = "Serveur RX302 ready/";
			byte[]         buffer  = message.getBytes(StandardCharsets.US_ASCII);
			
			System.out.println("Envoi de mess sur port");
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, this.ipClient, this.portClient);
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		
	}
}

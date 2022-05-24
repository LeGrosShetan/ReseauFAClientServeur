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
			
			String         message = "Hello Markiplier, my name is JackSepticeye/";
			byte[]         buffer  = message.getBytes(StandardCharsets.US_ASCII);
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, this.ipClient, this.portClient);
			System.out.println(this.ipClient + " " + InetAddress.getLocalHost() + " " + this.portClient);
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		
	}
}

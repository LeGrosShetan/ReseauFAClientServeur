package Base;
import java.io.IOException;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.random.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		serveur serveur = new serveur();
		client  client  = new client();
		
	
	}
	
	public static ArrayList<Integer> scan(int deb, int fin){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int i = deb; i <= fin; i++) {
			try {
				DatagramSocket cli = new DatagramSocket();
			}catch(SocketException ex) {
				System.err.println("Le port " + i + " est occupé");
				liste.add(i);
			}
		}
		return liste;
	}

}

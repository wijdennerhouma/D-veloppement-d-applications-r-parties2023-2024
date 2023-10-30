package tp4_2SOA;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Serveur {
	public static void main(String[] args ) {
		try {
			DatagramSocket serverSocket=new DatagramSocket(1238);
			System.out.println("le serveur est en attente de demandes...");
			while(true) {
				byte[] receiveData=new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				
				serverSocket.receive(receivePacket);
				
				
				InetAddress clientAddress=receivePacket.getAddress();
				int clientPort=receivePacket.getPort();
				
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
				String currentTime=dateFormat.format(new Date());
				byte[] sendDate = currentTime.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendDate, sendDate.length, clientAddress  , clientPort);
				
                serverSocket.send(sendPacket);

                System.out.println("Réponse envoyée au client: " + currentTime);
			}
		}catch (Exception e) {
            e.printStackTrace();}}}

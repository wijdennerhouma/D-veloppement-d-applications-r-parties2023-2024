package tp4_2SOA;
import java.net.*;
public class Client {
	public static void main(String[]args) {
		try {
			//creez un socket UDP pour le client
			DatagramSocket clientSocket=new DatagramSocket();
			
			//Adresse et port du serveur
			InetAddress serverAddress = InetAddress.getByName("localhost");
			int serverPort=1238;
			
			//Envoie une demande au serveur 
			byte[] sendData="Demander l' heure".getBytes();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);
			clientSocket.send(sendPacket);
			
			//attendez la réponse du serveur 
			byte[] receiveData=new byte[1024];
			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
			
			//affichez la date et l'heure recues du serveur 
			String currentTime=new String(receivePacket.getData(),0,receivePacket.getLength());
			System.out.println("Date et heure recues du serveur:"+currentTime);
			// Fermez le socket client
            clientSocket.close();
			
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

}

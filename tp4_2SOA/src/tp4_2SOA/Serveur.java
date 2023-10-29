package tp4_2SOA;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Serveur {
	public static void main(String[] args ) {
		try {
			//creez un socket UDP pour le serveur en ecoutant sur le port 1234
			DatagramSocket serverSocket=new DatagramSocket(1238);
			System.out.println("le serveur est en attente de demandes...");
			while(true) {
				/*utilisée pour recevoir des données du client dans le serveur UDP:
				  byte[] receiveData=new byte[1024]: un tableau de bytes de 1024 octets est créé. 
				  Ce tableau servira à stocker les données que le serveur 
				  reçoit du client. La taille de 1024 octets est utilisée comme une taille tampon 
				  (buffer) pour stocker les données entrantes*/
				
				  /*DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); :
				   Cette ligne crée un objet DatagramPacket nommé receivePacket. Un DatagramPacket est
				    utilisé pour stocker à la fois les données entrantes et des informations sur la source
				     des données, telles que l'adresse 
				   IP et le port du client.*/
				byte[] receiveData=new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				//attendez  une demande du client
				serverSocket.receive(receivePacket);
				
				
				InetAddress clientAddress=receivePacket.getAddress();
				int clientPort=receivePacket.getPort();
				
				//récupérez la date et l'heure actuelles
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				/*Cette chaîne de caractères formatée peut être utilisée pour afficher ou envoyer la date et l'heure dans un format spécifique, par exemple, pour répondre à une demande du client dans 
				le contexte de votre application client-serveur en UDP.*/
				String currentTime=dateFormat.format(new Date());
				byte[] sendDate = currentTime.getBytes();
				
				//Creez un paquet a envoyer en reponse 
				DatagramPacket sendPacket = new DatagramPacket(sendDate, sendDate.length, clientAddress  , clientPort);
				
				// Envoyez la date et l'heure au client
                serverSocket.send(sendPacket);

                System.out.println("Réponse envoyée au client: " + currentTime);
				
				
			}
			
		}catch (Exception e) {
            e.printStackTrace();
	}

}
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
	    try {
	      ServerSocket servidor = new ServerSocket(12345);
	      System.out.println("Servidor ouvindo a porta 12345");
	      while(true) {
	        Socket cliente = servidor.accept();
	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
	        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			String textoDigitado = entrada.readUTF();
			System.out.println("Texto recebido:\t" + textoDigitado);
			String textoTchau = "Mensagem recebida :"+ textoDigitado;
			DataOutputStream saidaTexto = new DataOutputStream(cliente.getOutputStream());
			saidaTexto.writeUTF(textoTchau);
	        cliente.close();
	      }  
	    }   
	    catch(Exception e) {
	       System.out.println("Erro: " + e.getMessage());
	    }
	  }     
}

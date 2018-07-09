import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPCliente {
	public static void main(String[] args) {
	    try {
	      Socket cliente = new Socket("127.0.0.1", 12345);
	      System.out.println("Digite o texto a ser enviado");
	      DataInputStream entrada = new DataInputStream(System.in);
	      String textoDigitado = entrada.readLine();
	      DataOutputStream enviar = new DataOutputStream(cliente.getOutputStream());
	      enviar.writeUTF(textoDigitado);
	      DataInputStream din = new DataInputStream(cliente.getInputStream());
	      String texto = din.readUTF();
	      System.out.println(texto);
	      System.out.println("Conexão encerrada");
	    }
	    catch(Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }
	  }
}

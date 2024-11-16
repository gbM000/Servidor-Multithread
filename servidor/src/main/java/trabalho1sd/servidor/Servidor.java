package trabalho1sd.servidor;

import trabalho1sd.servidor.connection.Servico;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gabe
 */

public class Servidor {

    public static void main(String[] args) {
        
        try{
            int porta = 1234;
            ServerSocket server = new ServerSocket(porta);
            System.out.println(".....Servidor Iniciado.....");
            while(true){
               Servico conection = new Servico(server.accept());
               conection.start();
                
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
}

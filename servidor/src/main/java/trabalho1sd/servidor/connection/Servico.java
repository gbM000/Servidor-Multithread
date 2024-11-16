package trabalho1sd.servidor.connection;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import trabalho1sd.servidor.database.LivroDAO;

/**
 *
 * @author gabe
 */
public class Servico extends Thread{
    
    private Socket cliente;

    public Servico(Socket c){
        this.cliente = c;
    }
    
    public void run(){
        System.out.println("Conexão com o cliente (Thread: " + this.getId() +") de ip: "+ cliente.getInetAddress());        
        
        try{
            InputStreamReader entrada = new InputStreamReader(cliente.getInputStream());
            BufferedReader dado = new BufferedReader(entrada);
            
            LivroDAO ld = new LivroDAO();
            String query = "select * from tb_livro where titulo like '" + dado + "%';";
            ld.search(query);
            Thread.sleep(5000);
            System.out.println("Conexão com o cliente: " + cliente.getInetAddress() + " encerrada (Thread: " + this.getId() +")");
            this.cliente.close();
        }catch(IOException | InterruptedException e){
            System.out.println("Erro" + e.getMessage());
        }
    }
    
}

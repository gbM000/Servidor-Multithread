/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package trabalho1sd.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gabe
 */
public class Cliente {

    public static void main(String[] args) {
        try{
            Socket client = new Socket("127.0.0.1", 1234);
            
            PrintStream ps = new PrintStream(client.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            
            String line = sc.next();
            
            ps.println(line);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

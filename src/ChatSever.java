
import chatapplication.chatUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameera
 */
public class ChatSever {
    
     public static void main(String args[])
    {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Writer op= new OutputStreamWriter(s.getOutputStream());
            chatUI client = new chatUI("server",op);
            
            String line;
            
            while((line=input.readLine())!=null)
            {
                client.appendText(line);
            }
            
        } catch (IOException ex) {
             Logger.getLogger(ChatSever.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        }
    
}

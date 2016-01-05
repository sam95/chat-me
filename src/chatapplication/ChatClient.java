/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sameera
 */
public class ChatClient {
    
    public static void main(String args[])
    {
        try {
            Socket s = new Socket("127.0.0.1", 1234);
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Writer op= new OutputStreamWriter(s.getOutputStream());
            
            chatUI client = new chatUI("client",op);
            
            String line;
            
            while((line=input.readLine())!=null)
            {
                client.appendText(line);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

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

/**
 *
 * @author Sameera
 */
public class ChatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        chatUI thechat = new chatUI("client",new OutputStreamWriter(System.out));
        String line;
        while((line=key.readLine())!=null){
            thechat.appendText(line);
            
        }
    }
    
}

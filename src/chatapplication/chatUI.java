/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sameera
 */
public class chatUI {

    private JFrame frame;
    private JTextArea textarea;
    private JScrollPane scroll;
    private JTextField field;

    public chatUI(final String text,final Writer output) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //To change body of generated methods, choose Tools | Templates.
                frame = new JFrame(text);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                textarea = new JTextArea();
                textarea.setEditable(false);
                scroll = new JScrollPane(textarea);
                frame.add(scroll, BorderLayout.CENTER);
                field = new JTextField();
                field.addActionListener(
                        new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s=field.getText();
                        try {
                            //System.out.println(s+"\n");
                            output.write(s+"\n");
                            output.flush();
                        } catch (IOException ex) {
                            textarea.append("The sender stuck up\n");
                        }
                        textarea.append("YOU:"+s+"\n");
                        field.setText("");
                    }
                }
                );
                
                frame.add(field, BorderLayout.SOUTH);
                frame.setBounds(20, 20, 300, 300);
                frame.setVisible(true);
            }
        });
    }
   public void appendText(final String text){
       SwingUtilities.invokeLater(new Runnable() {

           @Override
           public void run() {
               textarea.append("Him : "+text+"\n");
           }
       });
   }

}

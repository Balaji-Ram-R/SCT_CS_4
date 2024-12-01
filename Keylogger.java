import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Keylogger implements KeyListener{
    
    private BufferedWriter bw;
    public Keylogger(){

        try {
            bw = new BufferedWriter(new FileWriter("KeyLogger.txt",true));
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error writing "+e.getMessage());
        }

        JFrame frame = new JFrame("Key_Logger");
        JTextArea tArea = new JTextArea();

        tArea.addKeyListener(this);

        frame.add(new JScrollPane(tArea));
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        logKey(e,"Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private void logKey(KeyEvent e, String eventType){
        try {
            String keytxt = KeyEvent.getKeyText(e.getKeyCode());
            if (keytxt=="Space") {
                bw.write(keytxt+"\n");
            } else {
                bw.write(keytxt+" ");
            }
            //bw.write(keytxt+"\n");
            bw.flush();
        } catch (IOException ex) {
            // TODO: handle exception
            System.err.println("Error writing to file: "+ex.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Keylogger::new);
    }
}
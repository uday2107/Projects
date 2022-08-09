import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ImageCryptography {

    public static void selectFile(int key){

        JFileChooser fileChooser = new JFileChooser();
       fileChooser.showOpenDialog(null);
       File file = fileChooser.getSelectedFile();
       try {
           FileInputStream inputStream = new FileInputStream(file);
          byte[] data = new byte[inputStream.available()];
           inputStream.read(data);
           int i=0;
          for(byte x : data){
              System.out.println(x);
            data[i] = (byte) (x^key);
            i++;
          }
           FileOutputStream outputStream = new FileOutputStream(file);
          outputStream.write(data);
           inputStream.close();
           outputStream.close();
           JOptionPane.showMessageDialog(null,"Done");
       }catch(Exception e){
          e.printStackTrace();
       }


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Image Encryption and Decryption");
        frame.setSize(450,450);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //create Encryption and Decryption button
      Font font = new Font("Helvetica",Font.BOLD,20);

        JButton fileButton = new JButton();
        fileButton.setText("Select File");
        fileButton.setFont(font);
        fileButton.setBackground(Color.green);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setFont(font);


        fileButton.addActionListener(e -> selectFile(Integer.parseInt(textField.getText())));


        frame.add(fileButton);
        frame.add(textField);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

    }
}

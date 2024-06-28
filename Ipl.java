import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;

class Ipl extends JFrame 
{
    static int x = 0, y = 0;
    static JLabel counter = new JLabel(x + " : " + y);
    private Ipl()
    {
        getContentPane().setBackground(Color.BLACK);
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String [] rk)
    {
        Ipl mainpanel = new Ipl();
        Font f = new Font("Serif", Font.ITALIC, 30);
        JLabel l1 = new JLabel("PROJECT", SwingConstants.CENTER);
        l1.setFont(new Font("Serif", Font.BOLD, 40));
        l1.setForeground(Color.WHITE);
        l1.setBounds(95, 5, 500, 100);
        mainpanel.add(l1);

        JPanel p1 = new JPanel();
        p1.add(new JLabel("ENTER TEXT", SwingConstants.CENTER));
        p1.setBounds(80, 110, 525, 200);
        p1.setBackground(Color.GRAY);
        JLabel picLabel1 = new JLabel(new ImageIcon("cloudy.jpg"));
		p1.add(picLabel1);
        JTextField t1 = new JTextField();
        t1.setBounds(105, 175, 475, 100);
        t1.setFont(f);
        mainpanel.add(t1);
        mainpanel.add(p1);

        JButton b1 = new JButton("ADD");
        b1.setBounds(150, 340, 100, 50);
        mainpanel.add(b1);

        JButton b2 = new JButton("CLEAR");
        b2.setBounds(440, 340, 100, 50);
        mainpanel.add(b2);


        //Using Lambda Expressions to create a Listener (ActionListener) for Submit Button

b1.addActionListener(
    ae -> {
    if(ae.getActionCommand().equals("ADD"))
    {
        try{
            String output = t1.getText() + "\n";
            Files.write(Paths.get("File.txt"),output.getBytes(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(null, "Content Has Been Added To File");
        } catch(Exception e){JOptionPane.showMessageDialog(null, e+"error");}
    }
    }
    );
    //Using Lambda Expressions to create a Listener (ActionListener) for Reset Button
    b2.addActionListener(
    ae -> {
    if(ae.getActionCommand().equals("CLEAR"))
    {
    t1.setText(null);
    }
    }
    );
        

        mainpanel.setVisible(true);
    }
}
package thememo;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Thememo extends JFrame implements ActionListener {

    static JFrame f;
    static JTextField l;
    static JTextArea ta;

    public static void main(String[] args) {
        //basic properties of the app
        f = new JFrame("MY MEMO");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        ImageIcon img = new ImageIcon("C:\\Users\\redzuan\\Desktop\\thememo\\thememoicon.png");
        f.setIconImage(img.getImage());
        //create class object
        Thememo obj = new Thememo();
        //declare textField and textArea
        l = new JTextField(10);
        ta = new JTextArea();
        //declare all of the button
        JButton save, clear, history, delete_his;
        //creating the button visually 
        save = new JButton("save memo");
        clear = new JButton("clear");
        history = new JButton("history");
        delete_his = new JButton("delete history");
        //all used label properties
        JLabel date, memo;
        date = new JLabel("                   DATE(DD/MM/YY):");
        memo = new JLabel("                                       MEMO:");
        date.setFont(new Font("AERO", Font.BOLD, 20));
        memo.setFont(new Font("AERO", Font.BOLD, 20));
        date.setForeground(Color.black);
        memo.setForeground(Color.black);
        //creating panel and setting its layout 
        JPanel panel = new JPanel(new GridLayout(0, 2));
        //all of the used JButton properties 
        save.addActionListener(obj);
        save.setBackground(Color.orange);
        save.setFont(new Font("AERO", Font.BOLD, 20));
        clear.addActionListener(obj);
        clear.setBackground(Color.orange);
        clear.setFont(new Font("AERO", Font.BOLD, 20));
        history.addActionListener(obj);
        history.setBackground(Color.orange);
        history.setFont(new Font("AERO", Font.BOLD, 20));
        delete_his.addActionListener(obj);
        delete_his.setBackground(Color.orange);
        delete_his.setFont(new Font("AERO", Font.BOLD, 20));
        //attach all of the components onto the panel
        panel.add(date);
        panel.add(l);
        panel.add(memo);
        panel.add(ta);
        panel.add(save);
        panel.add(clear);
        panel.add(history);
        panel.add(delete_his);
        //additional panel and frame properties 
        panel.setBackground(Color.yellow);
        f.add(panel);
        f.setSize(600, 600);
        f.show();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String memomessage, date, fullmes;
        String s = a.getActionCommand();
        
        if (s.charAt(0) == 's') {//the event if "save memo" button clicked 
            date = l.getText();
            memomessage = ta.getText();
            fullmes = date + "\n" + memomessage + "\n";
            fungsi.totextfile(fullmes);
            fungsi.showmessage();
            
        } else if (s.charAt(0) == 'c') {//the event if "clear" button clicked
            l.setText("");
            ta.setText("");
            
        } else if (s.charAt(0) == 'h') {//the event if "history" button clicked
            try {
                storage.showHistory();
            } catch (IOException ex) {
                Logger.getLogger(Thememo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (s.charAt(0) == 'd') {//the event if "delete history" button clicked 
            try {
                storage.dlthis();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Thememo.class.getName()).log(Level.SEVERE, null, ex);
            }
            fungsi.deleteMessage();
        }

    }
}

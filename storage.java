package thememo;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class storage extends JFrame {

    /*this method is to make another frame to display the history 
    of all the memo saved */

    static void showHistory() throws FileNotFoundException, IOException {
        JFrame frem = new JFrame("MEMO HISTORY");
        frem.setSize(300, 700);
        frem.setResizable(false);
        frem.setVisible(true);
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(400, 400);
        JTextArea tea = new JTextArea();
        tea.setEditable(false);
        FileReader r = new FileReader("memo_record.txt");
        tea.read(r, "memo_record.txt");
        p.add(tea);
        frem.add(p, BorderLayout.CENTER);

    }

    /*this method to delete history of the memo saved */
    static void dlthis() throws FileNotFoundException {
        File f = new File("memo_record.txt");
        PrintWriter w = new PrintWriter(f);
        w.write("");
        w.close();

    }
}

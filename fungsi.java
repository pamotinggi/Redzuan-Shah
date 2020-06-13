package thememo;

import java.io.*;
import javax.swing.*;

public class fungsi {

    /*the function of this method is to store all the saved memo in a 
text file called memo_record.txt.
     */

    static void totextfile(String fullmes) {
        try {
            File f = new File("memo_record.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(fullmes);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }

    }

    /*this method just produce a pop up message telling the user that
    the memo is saved*/

    static void showmessage() {
        JOptionPane.showMessageDialog(null, "MEMO SAVED !");
    }

    /*this method just produce a pop up message telling the user that
    the history of the memo deleted*/
    static void deleteMessage() {
        JOptionPane.showMessageDialog(null, "MEMO HISTORY DELETED !");
    }

}

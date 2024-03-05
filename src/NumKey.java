import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumKey extends JButton {    
    public NumKey (int value) {
        this.setText(Integer.toString(value)); // set key display
        this.setFont(new Font("Calibri", Font.PLAIN, 18));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.type(value);
            }
        });
    }

}

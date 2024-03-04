import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumKey extends JButton {    
    public NumKey (int value) {

        if (Main.modeRoman) {
            this.setText(Main.getRoman(Integer.toString(value))); // set key to be roman value
        } else {
            this.setText(Integer.toString(value)); // set key display
        }

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.type(value);
            }
        });
    }

}

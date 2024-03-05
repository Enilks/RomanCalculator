import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RomKey extends JButton {
    private int value;
    
    public RomKey (int i) {
        switch (i) {
            case 1:
                value = 1;
                break;
            case 2:
                value = 5;
                break;
            case 3:
                value = 10;
                break;
            case 4:
                value = 50;
                break;
            case 5:
                value = 100;
                break;
            case 6:
                value = 500;
                break;
            case 7:
                value = 1000;
                break;
            default:
                value = 0;
                break;
        }
        setText(Main.getRoman(value));
        setFont(new Font("Times New Roman", Font.PLAIN, 18));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.type(value);
            }
        });
    }
}

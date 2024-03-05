import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Keypad extends JPanel {

    public Keypad() {
        int rows = 5;
        if (Main.modeRoman) rows = 4;

        setLayout(new GridLayout(rows, 3));
        setBackground(Color.pink);

        JButton allclear = new JButton("Clear All"); // AC button
        allclear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.clearAll();
            }
            
        });
        add(allclear);

        JButton clear = new JButton("Clear Entry"); // C button
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.clear();
            }
            
        });
        add(clear);

        JButton del = new JButton("Backspace");
        del.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.backspace();
            }
            
        });
        add(del);

        if (Main.modeRoman) {
            for (int i = 1; i < 7; i++) // add romKeys
                add(new RomKey(i));
        } else {
        for (int i = 0; i < 9; i++) // add numkeys
            add(new NumKey(i+1));
        }

        JButton switchModes = new JButton("Roman Mode"); // switch modes button
        if (Main.modeRoman) switchModes.setText("Normal Mode");
        switchModes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.modeRoman) {
                    Main.modeRoman = false;
                    Readout.toggleRO(false);
                } else {
                    Main.modeRoman = true;
                    Readout.toggleRO(true);
                }
                Main.updateKeypad();
            }
            
        });
        add(switchModes);

        if (Main.modeRoman) {
            add(new RomKey(7));
        } else {
            add(new NumKey(0)); // add 0 key
        }

        JButton eqls = new JButton("="); // equals button
        eqls.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.solve();
            }
            
        });
        eqls.setFont(new Font("Calibri", Font.PLAIN, 24));
        add(eqls);

    }
}

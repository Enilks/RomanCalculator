import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Keypad extends JPanel {

    public Keypad() {
        setLayout(new GridLayout(5, 3));
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
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        add(clear);

        JButton del = new JButton("Backspace");
        del.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.backspace();
                System.out.println("H: " + Main.getFrameHeight() + "  W: " + Main.getFrameWidth());
            }
            
        });
        add(del);

        for (int i = 0; i < 9; i++) // add numkeys
            add(new NumKey(i+1));
            
        JButton switchModes = new JButton("Roman off"); // switch modes button
        if (Main.modeRoman) switchModes.setText("Roman on");
        switchModes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        add(switchModes);

        add(new NumKey(0)); // add 0 key

        JButton eqls = new JButton("="); // equals button
        eqls.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        add(eqls);

    }
}

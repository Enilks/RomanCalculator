import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Functions extends JPanel {

    public Functions() {
        setLayout(new GridLayout(5, 1));

        JButton div = new JButton("/");
        div.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.nextEntry();
                Readout.func = '/';
            }
            
        });
        add(div);

        JButton mult = new JButton("x");
        mult.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.nextEntry();
                Readout.func = 'x';
            }
            
        });
        add(mult);

        JButton sub = new JButton("-");
        sub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.nextEntry();
                Readout.func = '-';
            }
            
        });
        add(sub);

        JButton add = new JButton("+");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.nextEntry();
                Readout.func = '+';
            }
            
        });
        add(add);

        JButton sqr = new JButton("sqr");
        sqr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int r = Integer.valueOf(Readout.readout);
                Readout.readout = Integer.toString(r*r);
            }
            
        });
        add(sqr);

    }


}

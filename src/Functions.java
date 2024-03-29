import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Functions extends JPanel {
    private static FButton div;
    private static FButton mult;
    private static FButton sub;
    private static FButton add;
    private static JButton sqr;

    public static boolean hasSelection = false;

    public Functions() {
        setLayout(new GridLayout(5, 1));
        setBackground(Color.white);

        div = new FButton("/");
        add(div);

        mult = new FButton("x");
        add(mult);

        sub = new FButton("-");
        add(sub);

        add = new FButton("+");
        add(add);

        sqr = new JButton("sqr");
        sqr.setBackground(Color.white);
        sqr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Readout.square();
            }
            
        });
        add(sqr);

    }

    public static void deselectAll(){
        hasSelection = false;
        div.setSelected(false);
        mult.setSelected(false);
        sub.setSelected(false);
        add.setSelected(false);
        sqr.setSelected(false);
    }

}

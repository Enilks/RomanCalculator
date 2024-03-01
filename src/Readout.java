import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Readout extends JPanel {
    public static String readout = "0";
    private static boolean romanRO = true;

    private static JLabel label = new JLabel(readout);

    private final Font font = new Font("Calibri", Font.PLAIN, 30);
    private final Font bold = new Font("Calibri", Font.BOLD, 30);

    public Readout() {
        this.setBackground(new Color(0, 21, 110));
        this.setLayout(new BorderLayout(10, 0));
        label.setForeground(Color.white);
        label.setFont(font);
        this.add(label, BorderLayout.LINE_END);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (romanRO) {
                    romanRO = false;
                } else {
                    romanRO = true;
                }

                update();
            }

            // Idea - For the following two methods, add a timer so that after the mouse has hovered over for a lil bit, the format switches until the mouse hovers off.
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setFont(bold);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(font);
            }
            
        });
    }

    public static void type(int num) {
        if (readout == "0") readout = "";
        readout += Integer.toString(num);
        System.out.println("Readout Value: " + readout + "   Roman: " + Main.getRoman(readout));
        update();
    }

    public static void update() {
        if (romanRO) {
            if (readout == "0") {
                label.setText("--");
            } else {
                label.setText(Main.getRoman(readout));
            }
        } else {
            label.setText(readout);
        }
    }

    public static void backspace() {
        readout = readout.substring(0, (readout.length()-1));
        update();
    }

    public static void clear() {
        readout = "0";
        update();
    }

    
}

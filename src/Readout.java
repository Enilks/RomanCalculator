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
    public static String stored;
    public static boolean needsNextEntry = false;

    public static char func;

    private static boolean romanRO = false;

    private static JLabel label = new JLabel(readout);

    private final Font font = new Font("Calibri", Font.PLAIN, 42);
    private final Font bold = new Font("Calibri", Font.BOLD, 42);
    private final Font roman = new Font("Times New Roman", Font.PLAIN, 42);
    private final Font romanBold = new Font ("Times New Roman", Font.BOLD, 42);

    public Readout() {
        this.setBackground(new Color(0, 21, 110));
        this.setLayout(new BorderLayout(10, 0));
        label.setForeground(Color.white);
        label.setFont(font);
        if (romanRO) label.setFont(roman);

        this.add(label, BorderLayout.LINE_END);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleRO();
            }

            // Idea - For the following two methods, add a timer so that after the mouse has hovered over for a lil bit, the format switches until the mouse hovers off.
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setFont(bold);
                if (romanRO) label.setFont(romanBold);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(font);
                if (romanRO) label.setFont(romanBold);
            }
            
        });
    }

    public static void toggleRO() {
        if (romanRO) romanRO = false;
        else romanRO = true;
        update();
    }
    public static void toggleRO(boolean bool) {
        romanRO = bool;
        update();
    }

    public static void type(int num) {
        if (readout.equals("0") || needsNextEntry) readout = "";
        needsNextEntry = false;
        Functions.deselectAll();
        if (Main.modeRoman) {
            String s = Main.getRoman(readout) + Main.getRoman(num);
            label.setText(s);
            readout = Integer.toString(Main.toNumbers(s));
        } else {
            readout += Integer.toString(num);
        }
        // System.out.println("Readout Value: " + readout + "   Roman: " + Main.getRoman(readout));
        update();
    }

    public static void update() {
        if (romanRO) {
            if (readout == "0") {
                label.setText(" ");
            } else {
                label.setText(Main.getRoman(readout));
            }
        } else {
            label.setText(readout);
        }
    }

    public static void backspace() {
        if (readout.equals(0)) return;
        readout = readout.substring(0, (readout.length()-1));
        update();
    }

    public static void clearAll() {
        readout = "0";
        stored = null;
        Functions.deselectAll();
        func = ' ';
        update();
    }

    public static void clear() {
        readout = "0";
        update();
    }

    public static void nextEntry() {
        if (stored != null) {
            solve();
        } else {
            stored = readout;
        }
        needsNextEntry = true;
    }

    public static void solve() {
        int sto;
        try {
            sto = Integer.valueOf(stored);
        } catch (NumberFormatException e) {
            return;
        }
        int ro = Integer.valueOf(readout);
        int ans = 0;
        switch (func) {
            case '/':
                ans = sto/ro;
                break;
            case 'x':
                ans = sto*ro;
                break;
            case '-':
                ans = sto - ro;
                break;
            case '+':
                ans = sto + ro;
        }

        readout = Integer.toString(ans);
        stored = null;
        update();
    }

    
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.DecimalFormat;

public class Readout extends JPanel {
    public static String readout = "0";
    public static String stored;
    public static boolean needsNextEntry = false;

    public static char func;

    private static boolean romanRO = false;

    private static JLabel label = new JLabel(readout);

    private final static Font font = new Font("Calibri", Font.PLAIN, 42);
    private static final Font roman = new Font("Times New Roman", Font.PLAIN, 42);

    private final static DecimalFormat fmt = new DecimalFormat("#,###");

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
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(font);
                if (romanRO) label.setFont(roman);
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
        if (readout.equals("0") || needsNextEntry || readout.equals(Main.error)) readout = "";
        needsNextEntry = false;
        Functions.deselectAll();
        if (Main.modeRoman) {
            String s = Main.getRoman(readout) + Main.getRoman(num);
            label.setText(s);
            readout = Integer.toString(Main.getNumbers(s));
        } else {
            readout += Integer.toString(num);
        }
        update();
    }

    public static void update() {
        if (romanRO) {
            if (readout == "0") {
                label.setText(" ");
            } else {
                label.setText(Main.getRoman(readout));
            }
            label.setFont(roman);
        } else {
            String out = fmt.format(Double.valueOf(readout));
            label.setText(out);
            label.setFont(font);
        }
    }

    public static void backspace() {
        if (readout.equals(0)) return;
        if (romanRO) {
            String s = Main.getRoman(readout);
            s = s.substring(0, s.length()-1);
            readout = Main.getNumbersString(s);
        } else {
            readout = readout.substring(0, (readout.length()-1));
        }
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

    public static void square() {
        int ro = Integer.valueOf(readout);
        readout = Integer.toString(ro*ro);
        update();
    }
}

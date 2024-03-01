import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static JFrame cFrame;
    private static JPanel keypad;

    private static Readout readout;

    private static String romanString = "";

    public static boolean romanKeys = false;

    public static void main(String[] args) {
        
        if (args.length > 0) { // check for args
            Scanner scan = new Scanner(args[0]);
            String n;
            boolean roman = false;
            try {
                n = Integer.toString(scan.nextInt());
            } catch (InputMismatchException e) {
                n = args[0];
                roman = true;
            } finally {
                scan.close();
            }

            if (roman) {
                System.out.println("Converting Roman Numerals \"" + n + "\" to Base 10.");
                toNumbers(n);
            } else {
                System.out.println("Converting Base 10 \"" + n + "\" to Roman Numerals.");
                toRoman(n);
            }
        } else {
            cFrame = new JFrame("Roman Calculator"); // create jFrame
            cFrame.setLayout(new BorderLayout());
            cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            readout = new Readout(); // create readout

            keypad = new JPanel(new GridLayout(4, 3));
            keypad.setBackground(Color.pink);
            

            for (int i = 0; i < 10; i++) { // add numkeys
                NumKey key;
                if (i < 9) {
                    key = new NumKey(i+1);
                } else {
                    // this positions 0 at the end
                    key = new NumKey(0);
                }
                keypad.add(key);
            }
            
            JButton del = new JButton("del");
            del.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Readout.backspace();
                }
                
            });
            keypad.add(del);

            JButton clear = new JButton("clr");
            clear.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Readout.clear();
                }
                
            });
            keypad.add(clear);

            cFrame.add(keypad, BorderLayout.CENTER);
            cFrame.add(readout, BorderLayout.NORTH);
            cFrame.pack();
            cFrame.setVisible(true);
        }
    }

    public static int getFrameHeight() {
        return cFrame.getHeight();
    }
    public static int getFrameWidth() {
        return cFrame.getWidth();
    }

    private static void toNumbers(String n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toNumbers'");
    }

    public static void toRoman(String value) {
        int n = Integer.parseInt(value);
        romanString = "";

        if (n >= 4000) {
            System.out.println("Cannot convert to roman numerals (Too Large)");
            return;
        }

        System.out.print("Converting " + n + " to Roman numerals...");
        for (int place = value.length(); place > 0; place--) {
            int loc = value.length() - place; // find place location in string
            int val = Integer.parseInt(value.substring(loc, loc+1)); // get place value
            // System.out.println("Place: " + place + "   Value: " + val);
            String l = getPlaceLetter(place);
            String l2 = getPlaceLetter(place, true);

            if (val < 4) {
                addLetters(l, val);
            } else if (val == 4) {
                romanString += (l + l2);
            } else if (val < 9) {
                romanString += l2;
                addLetters(l, val-5);
            } else {
                romanString += (l + getPlaceLetter(place + 1));
            }

        }
        System.out.println("Done.");

        System.out.println(romanString);
    }
    public static String getRoman(String value) {
        int n = Integer.parseInt(value);
        String rString = "";

        if (n >= 4000) {
            System.out.println("Cannot convert to roman numerals (Too Large)");
            return null;
        }

        for (int place = value.length(); place > 0; place--) {
            int loc = value.length() - place; // find place location in string
            int val = Integer.parseInt(value.substring(loc, loc+1)); // get place value
            String l = getPlaceLetter(place);
            String l2 = getPlaceLetter(place, true);

            if (val < 4) {
                rString += returnLetters(l, val);
            } else if (val == 4) {
                rString += (l + l2);
            } else if (val < 9) {
                rString += l2;
                rString += returnLetters(l, val-5);
            } else {
                rString += (l + getPlaceLetter(place + 1));
            }

        }

        return rString;
    }
    
    public static String getRoman(int value) {
        return getRoman(Integer.toString(value));
    }

    private static void addLetters(String letter, int amount) {
        for (int i = 0; i < amount; i++) {
            romanString += letter;
        }
    }
    private static String returnLetters(String letter, int amount) {
        String s = "";
        for (int i = 0; i < amount; i++) {
            s += letter;
        }
        return s;
    }
    

    private static String getPlaceLetter(int place) {
        switch (place) {
            case 1: return "I";
            case 2: return "X";
            case 3: return "C";
            case 4: return "M";
        }
        return "?";
    }
    private static String getPlaceLetter(int place, boolean subtrahend) {
        if (subtrahend) {
            switch (place) {
                case 1: return "V";
                case 2: return "L";
                case 3: return "D";
            }
        } else {
            return getPlaceLetter(place);
        }
        return "?";
    }

}

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FButton extends JButton {
    private final Font font = new Font("Calibri", Font.PLAIN, 24);
    private boolean selected = false;

    public FButton(String function) {
        setText(function);
        setFont(font);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setOpaque(true);
        setFocusPainted(false);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // todo - make so i can unselect
                if (selected) {
                    Functions.deselectAll();
                } else {
                    if (Functions.hasSelection) {
                        Functions.deselectAll();
                    } else {
                        Readout.nextEntry();
                    }
                    setSelected(true);
                    Functions.hasSelection = true;
                    Readout.func = function.charAt(0);
                }
            }
            
        });
    }

    public void setSelected(boolean bool) {
        this.selected = bool;
        if (bool) {
            setForeground(Color.WHITE);
            setBackground(Color.BLACK);
        } else {
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
        }
        revalidate();
    }
}

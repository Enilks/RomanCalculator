import java.awt.GridLayout;

import javax.swing.JPanel;

public class Functions extends JPanel {
    private static FButton div;
    private static FButton mult;
    private static FButton sub;
    private static FButton add;
    private static FButton sqr;

    public static boolean hasSelection = false;

    public Functions() {
        setLayout(new GridLayout(5, 1));

        div = new FButton("/");
        add(div);

        mult = new FButton("x");
        add(mult);

        sub = new FButton("-");
        add(sub);

        add = new FButton("+");
        add(add);

        sqr = new FButton("sqr");
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

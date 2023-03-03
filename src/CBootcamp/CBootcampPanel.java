package CBootcamp;

import CCoders.Coders;

public class CBootcampPanel extends Bootcamp{
    Bootcamp f = new Bootcamp();
    public void panelBootcamp(){
        f.setContentPane(new Bootcamp().PANEL_BOOTCAMP);
        f.setVisible(true);
        f.pack();
    }
}

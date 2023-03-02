package Clases;

public class CPanel extends Coders {
    Coders f = new Coders();
    public void panel() {
        idText.setEnabled(false);
        f.setContentPane(new Coders().PANEL_CODERS);
        f.setVisible(true);
        f.pack();
    }
}

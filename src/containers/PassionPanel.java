package containers;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PassionPanel extends JScrollPane {

    private static final long serialVersionUID = 1L;

    private final JTextArea passionArea;

    /**
     * Constructor.
     */
    public PassionPanel() {
        passionArea = new JTextArea();
        createGUI();
    }

    private void createGUI() {
        // Gestion des passions. C'est un panneau spécial qui peut avoir des
        // ascenseurs. JScrollPane est la classe qu'il nous faut.
        // Un objet JScrollPane contient un objet "viewport", qui est une
        // fenêtre de visualisation dans un texte plus grand.
        // C'est un JTextArea qui servira de viewport.
        passionArea.setLineWrap(true); // Retour à la ligne au bord de l'écran
        passionArea.setWrapStyleWord(true); // Retour à la ligne selon les

        // Une fenêtre avec ascenseurs pour contenir notre texte
        this.setViewportView(passionArea);
        this.setBorder(BorderFactory.createTitledBorder("Passions"));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setPreferredSize(new Dimension(100, 200));
    }
}

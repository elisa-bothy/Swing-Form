package containers;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class LanguagePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final String[] LANGUAGES = { // La liste des langages
        "C", "C++", "C#",
        "Java SE", "Java EE",
        "Python", "Shell", "Delphi",
        "Pascal", "TurboPascal"
    };

    private final int column;

    /**
     * Constructor avec 3 colonnes par défaut.
     */
    public LanguagePanel() {
        this(3);
    }

    /**
     * Constructeur avec un nombre choisi de colonnes.
     *
     * @param column Le nombre de colonnes
     */
    public LanguagePanel(int column) {
        this.column = column;
        createGUI();
    }

    private void createGUI() {
        // Gestion des langages. On les affichera sur 3 colonnes => c'est un
        // GridLayout où on force le nombre de colonnes à 3
        this.setLayout(new GridLayout(0, column));
        this.setBorder(BorderFactory.createTitledBorder("Langages"));
        for (String lang : LANGUAGES) {
            JCheckBox jc = new JCheckBox(lang); // Création des checkboxes
            this.add(jc);
        }
    }

}

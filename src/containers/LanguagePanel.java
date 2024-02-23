package containers;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LanguagePanel extends JPanel {
    static ImageIcon icon = new ImageIcon("images.jpeg");

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
            jc.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.DESELECTED){
                System.out.println("déselection");
             
            }else{
                System.out.println("sélection");
                System.out.println(((JCheckBox) e.getSource()).getText());
            }
            if (((JCheckBox) e.getSource()).getText()== "Java SE" || ((JCheckBox) e.getSource()).getText()== "Java EE"){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(
                    null, 
                    "Vous avez eu l'immence honneur de séléctionner Java", 
                    "Votre choix", 
                    JOptionPane.PLAIN_MESSAGE,
                    icon );
                    }
                });
               
            }
        });
        }
    }

}

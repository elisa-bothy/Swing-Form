package MainClass;

import containers.AddressPanel;
import containers.CivilityPanel;
import containers.LanguagePanel;
import containers.PassionPanel;
import javax.swing.Box;
import javax.swing.JFrame;

public class Formulaire extends JFrame {

    private static final long serialVersionUID = 1L;

    private final Box content; // Le panneau global
    private final CivilityPanel civPanel; // Le panneau de la civilité
    private final AddressPanel adrPanel; // Le panneau de l'adresse
    private final LanguagePanel langPanel; // Le panneau des langages utilisés
    private final PassionPanel passionPanel; // Le panneau des passions

    public Formulaire() {
        // Initialisation des variables d'instance
        this.content = Box.createVerticalBox();
        this.civPanel = new CivilityPanel();
        this.adrPanel = new AddressPanel();
        this.langPanel = new LanguagePanel();
        this.passionPanel = new PassionPanel();

        // Initialisation du contenu graphique
        this.initGui();

        // Configuration de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(false); // Fenêtre non-redimensionnable
        this.pack(); // Ajustement de la taille au contenu
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true); // Affichage de la fenêtre

    }

    private void initGui() {
        // Ajout des différents panneaux dans le contenu
        this.content.add(civPanel);
        this.content.add(adrPanel);
        this.content.add(langPanel);
        this.content.add(passionPanel);
        // Ma box content devient le contentPane
        this.setContentPane(content);
    }
}

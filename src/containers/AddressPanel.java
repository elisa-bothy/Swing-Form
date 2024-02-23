package containers;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AddressPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final LabelAndField numPanel, ruePanel, cpPanel, comPanel;

    /**
     * Constructor
     */
    public AddressPanel() {
        numPanel = new LabelAndField("Numéro ", 25, "Numéro du domicile dans la rue");
        ruePanel = new LabelAndField("Rue", 25, "Nom de la voie");
        cpPanel = new LabelAndField("CP", 25, "Code postal");
        comPanel = new LabelAndField("Commune", 25, "Commune");
        initGui();
    }

    private void initGui() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Adresse"));
        // Ajout des composant au panneau
        this.add(numPanel);
        this.add(ruePanel);
        this.add(cpPanel);
        this.add(comPanel);
    }
}

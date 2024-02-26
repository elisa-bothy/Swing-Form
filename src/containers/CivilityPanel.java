package containers;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CivilityPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    // Création d'un tableau des mois pour la combobox.
    private static final String[] MONTHS = {
        "Janvier", "Février", "Mars", "Avril",
        "Mai", "Juin", "Juillet", "Août",
        "Septembre", "Octobre", "Novembre", "Décembre"
    };

    private final JPanel civList, birthPanel;
    private final LabelAndField namePanel, fornamePanel;
    private final JComboBox birthDay, birthMonth, birthYear;
    private final ButtonGroup civGroup;
    private final JLabel birthLabel;
    
    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public CivilityPanel() {
        civList = new JPanel();
        birthPanel = new JPanel();
        civGroup = new ButtonGroup();
        birthLabel = new JLabel();
        namePanel = new LabelAndField("Nom", 25, "Entrez votre nom");
        fornamePanel = new LabelAndField("Prénom", 25, "Entrez votre prénom");
        // Création d'une liste de valeurs de 1 à 31 pour la combobox.
        // Pour bien faire, en fonction du mois choisi, il faudrait donner les
        // bonnes valeurs, mais ce n'est pas le sujet de cet exercice
        // On pourrait aussi utiliser un composant calendrier... Cherchez !
        Collection<Integer> days = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            days.add(i);
        }
        birthDay = new JComboBox(days.toArray());
        birthMonth = new JComboBox(MONTHS);
        // Création de la liste des années de 1945 à l'année courante
        // pour le combobox.
        Collection<Integer> years = new ArrayList<>();
        for (int i = 1945; i <= LocalDate.now().getYear(); i++) {
            years.add(i);
        }
        namePanel.getTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.println(ke.getKeyChar());
            }
        });
        fornamePanel.getTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {}

            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.println(ke.getKeyChar());
            }
        });
        birthYear = new JComboBox(years.toArray());
        birthYear.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.SELECTED){
                System.out.println("Vous avez sélectionné "+((JComboBox)(e.getSource()))
                        .getSelectedItem()); 
            }
        });
        birthDay.addItemListener((e)->{;
            if(e.getStateChange() == ItemEvent.SELECTED){
                System.out.println("Vous avez sélectionné "+((JComboBox)(e.getSource()))
                        .getSelectedItem()); 
            }
        });
        birthMonth.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.SELECTED){
                System.out.println("Vous avez sélectionné "+((JComboBox)(e.getSource()))
                        .getSelectedItem());                
            }
        });
        createGUI();
    }

    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Civilité"));
        // La liste des civilités M., Mme, et Mlle
        // On les veut alignés à gauche, il faut donc les mettre dans un JPanel
        // dont le contenu est aligné à gauche : c'est un FlowLayout à gauche
        civList.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Des boutons radios doivent appartenir à un groupe de boutons.
        // C'est le groupe qui se charge de n'avoir qu'un seul bouton
        // sélectionné.
        // Mais on ne peut pas ajouter un groupe dans un JPanel,
        // ce n'est pas un composant. Ce n'est qu'un groupement logique des
        // boutons entre eux. Il faut donc bien également ajouter les boutons
        // au JPanel
        String[] civs = {"M.", "Mme", "Mlle"}; // Les labels des boutons radio
        for (String civ : civs) {
            JRadioButton jb = new JRadioButton(civ);
            civGroup.add(jb); // Ajout au groupe
            civList.add(jb); // Ajout au JPanel
            jb.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                System.out.println(selectedButton.getText());
            }
            });
        }
        // Gestion de la date de naissance. On a 4 champs qui doivent s'aligner
        // à gauche, on utilise donc un JPanel muni d'un FlowLayout à gauche
        birthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        birthLabel.setText("Date de naissance "); // Le label de la date de naissance
        birthPanel.add(birthLabel); // Ajout au panneau
        birthPanel.add(birthDay); // Ajout au panneau
        birthPanel.add(birthMonth); // Ajout au panneau
        birthPanel.add(birthYear); // Ajout au panneau

        // Ajout des différents sous-panneaux au panneau civPanel
        this.add(civList);
        this.add(namePanel);
        this.add(fornamePanel);
        this.add(birthPanel);
    }
}

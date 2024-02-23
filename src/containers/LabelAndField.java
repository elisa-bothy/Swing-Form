package containers;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Association alignée d'un label et d'un champ de saisie. Pour que les champs
 * soient alignés, on peut utiliser un GridBagLayout, ou tricher en utilisant
 * les régions EAST et WEST d'un BorderLayout (ou accepter que les champs texte
 * ne soient pas alignés...)
 *
 * @author Herbert Caffarel <herbert.caffarel@cicef.pro>
 */

public class LabelAndField extends JPanel {

    private JLabel label;
    private JTextField textField;

    public LabelAndField(String label, int size) {
        this.setLayout(new BorderLayout());
        this.label = new JLabel(label);
        this.textField = new JTextField(size);
        this.add(this.label, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.EAST);
    }

    public LabelAndField(String label, int size, String toolTip) {
        this(label, size);
        this.textField.setToolTipText(toolTip);
    }

    public JTextField getTextField() {
        return textField;
    }

}

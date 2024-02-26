package containers;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

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

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

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

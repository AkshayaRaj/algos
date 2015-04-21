package studentDB;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
/**
*
* @author ndunn
*/
public class Entry extends JPanel {
private JComboBox comboBox;
private JTextField textField;
private JButton plus;
private JButton minus;
private EntryList parent;
private JCheckBox checkBox;
public boolean data;

private ArrayList<JTextField> cols;

 
public Entry(JComboBox comboBox, String textFieldText, EntryList list, JCheckBox checkBox) {
	this.data=false;
this.checkBox=checkBox;
this.comboBox = comboBox;
this.parent = list;
this.plus = new JButton(new AddEntryAction());
this.minus = new JButton(new RemoveEntryAction());
this.textField = new JTextField(10);
this.textField.setText(textFieldText);
add(this.plus);
add(this.minus);
add(this.comboBox);
add(this.textField);
add(this.checkBox);
}

public Entry(ArrayList<JTextField> cols,EntryList list){
	this.data=true;
	this.cols=cols;
	this.parent=list;
	this.plus = new JButton(new AddEntryAction());
	this.minus = new JButton(new RemoveEntryAction());
	for(JTextField tf: cols){
		add(tf);
	}
	
	
}
 
public JComboBox getComboBox() {
return comboBox;
}


 
public ArrayList<JTextField> getCols() {
	return cols;
}

public JCheckBox getCheckBox(){
	return checkBox;
}
public class AddEntryAction extends AbstractAction {
 
public AddEntryAction() {
super("+");
}
 
public void actionPerformed(ActionEvent e) {
parent.cloneEntry(Entry.this);
}
 
}
 
public class RemoveEntryAction extends AbstractAction {
 
public RemoveEntryAction() {
super("-");
}
 
public void actionPerformed(ActionEvent e) {
parent.removeItem(Entry.this);
}
}
 
public void enableAdd(boolean enabled) {
this.plus.setEnabled(enabled);
}
public void enableMinus(boolean enabled) {
this.minus.setEnabled(enabled);
}
} 
package studentDB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ndunn
 */
public class EntryList extends JPanel{
    private List<Entry> entries;
    // Replace with your database stuff
    private static final String[] comboBoxEntries = {"INT","Char","Float"};
    private static final String CHECK_STRING = "PRIMARY KEY";


    public EntryList() {
        this.entries = new ArrayList<Entry>();

        Entry initial = new Entry(new JComboBox(comboBoxEntries), "", this,new JCheckBox(CHECK_STRING));
       
        addItem(initial);
    }

    public void cloneEntry(Entry entry) {
    	if(entry.data==false){
        Object selected = entry.getComboBox().getSelectedItem();
        JComboBox copy = new JComboBox(comboBoxEntries);
        copy.setSelectedItem(selected);
        Entry theClone = new Entry(copy, "", this,new JCheckBox(CHECK_STRING));

        addItem(theClone);
        }
    	
    	else{
    		JTextField j_name=new JTextField("Name");
    		JTextField j_id=new JTextField("ID");
    		JTextField j_m1=new JTextField("M1");
    		JTextField j_m2=new JTextField("M2");
    		JTextField j_m3=new JTextField("M3");
    		JTextField j_total=new JTextField("total");
    		ArrayList<JTextField> cols=new ArrayList<>();;
    		cols.add(j_name);
    		cols.add(j_id);
    		cols.add(j_m1);
    		cols.add(j_m2);
    		cols.add(j_m3);
    		cols.add(j_total);
    		Entry theClone = new Entry(cols,this);
    	}
    	
    	
    	
    }

    private void addItem(Entry entry) {
        entries.add(entry);

        add(entry);
        refresh();
    }

    public void removeItem(Entry entry) {
        entries.remove(entry);
        remove(entry);
        refresh();
    }

    private void refresh() {
        revalidate();

        if (entries.size() == 1) {
            entries.get(0).enableMinus(false);
        }
        else {
            for (Entry e : entries) {
                e.enableMinus(true);
            }
        }
    }

}

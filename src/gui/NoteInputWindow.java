package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Infrastructure.NoteManager;

public class NoteInputWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel notePanel;
	private JTextField noteText;
	private JLabel noteTextLabel;
	private JLabel categoryLabel;
	private JComboBox<String> categoriesSelect;
	
	public NoteInputWindow(NoteManager manager, NoteWindow window) { 
		//this constructor is for adding notes
		GridBagConstraints cons = new GridBagConstraints();
		noteTextLabel = new JLabel("Note content");
		categoryLabel = new JLabel("category");
		init(cons, manager);
		
		cons.insets = new Insets(20, 20, 30, 20);
		cons.gridx = 1;
		cons.gridy = 5;
		cons.weightx = 0.4;
		cons.gridheight = 2;
		JButton confirm = new JButton("Add note");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				manager.addNote(noteText.getText(), categoriesSelect.getEditor().getItem().toString());
				closeWindow();
				
			}
		});
		notePanel.add(confirm, cons);
		
		this.add(notePanel);
		this.pack();
		this.setVisible(true);
	}
	
	public NoteInputWindow(NoteManager manager, int noteId) { 
		//this constructor is for editing notes
		GridBagConstraints cons = new GridBagConstraints();
		noteTextLabel = new JLabel("New note text");
		categoryLabel = new JLabel("New category");
		init(cons, manager);
		
		cons.insets = new Insets(20, 20, 30, 20);
		cons.gridx = 1;
		cons.gridy = 5;
		cons.weightx = 0.4;
		cons.gridheight = 2;
		JButton confirm = new JButton("Edit note");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				manager.editNote(noteId, noteText.getText(), categoriesSelect.getEditor().getItem().toString());
				closeWindow();
				
			}
		});
		notePanel.add(confirm, cons);
		
		this.add(notePanel);
		this.pack();
		this.setVisible(true);
	}
	
	private void init(GridBagConstraints cons, NoteManager manager) {
		notePanel = new JPanel();
		notePanel.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		notePanel.setPreferredSize(new Dimension(300, 200));
		notePanel.setMinimumSize(new Dimension(100, 200));
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.anchor = GridBagConstraints.WEST;
		cons.insets = new Insets(0, 20, 5, 20);
		notePanel.add(noteTextLabel, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 4;
		cons.gridheight = 2;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.insets = new Insets(0, 20, 30, 20);
		cons.fill = GridBagConstraints.BOTH;
		noteText = new JTextField();
		notePanel.add(noteText, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 5;
		cons.weightx = 0.6;
		cons.weighty = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.insets = new Insets(0, 20, 5, 20);
		notePanel.add(categoryLabel, cons);
		
		cons.gridy = 6;
		cons.insets = new Insets(0, 20, 30, 20);
		this.categoriesSelect = new JComboBox<String>(manager.getCategories().toArray(new String[0]));
		categoriesSelect.setPrototypeDisplayValue("Choose category");
		categoriesSelect.setEditable(true);
		notePanel.add(categoriesSelect, cons);
		
		
	}
	
	private void closeWindow() {
		this.dispose();
	}
}

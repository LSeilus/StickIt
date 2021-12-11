package gui;

import Infrastructure.NoteManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class AddNoteWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel addNotePanel;
	private JTextArea noteText;
	private JLabel noteTextLabel;
	private JLabel categoryLabel;
	
	public AddNoteWindow(String[] cats, NoteManager manager, NoteWindow window) { 
		addNotePanel = new JPanel();
		addNotePanel.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagConstraints cons = new GridBagConstraints();
		addNotePanel.setPreferredSize(new Dimension(300, 200));
		addNotePanel.setMinimumSize(new Dimension(100, 200));
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.anchor = GridBagConstraints.WEST;
		cons.insets = new Insets(0, 20, 5, 20);
		noteTextLabel = new JLabel("Note content");
		addNotePanel.add(noteTextLabel, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 4;
		cons.gridheight = 2;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.insets = new Insets(0, 20, 30, 20);
		cons.fill = GridBagConstraints.BOTH;
		noteText = new JTextArea();
		addNotePanel.add(noteText, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 5;
		cons.weightx = 0.6;
		cons.weighty = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.insets = new Insets(0, 20, 5, 20);
		categoryLabel = new JLabel("category");
		addNotePanel.add(categoryLabel, cons);
		
		cons.gridy = 6;
		cons.insets = new Insets(0, 20, 30, 20);
		JComboBox<String> categoriesSelect = new JComboBox<String>(cats);
		categoriesSelect.setPrototypeDisplayValue("Choose category");
		categoriesSelect.setEditable(true);
		addNotePanel.add(categoriesSelect, cons);
		
		
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
				window.redraw(manager);
				closeWindow();
				
			}
		});
		addNotePanel.add(confirm, cons);
		
		this.add(addNotePanel);
		this.pack();
		this.setVisible(true);
	}
	private void closeWindow() {
		this.dispose();
	}
}

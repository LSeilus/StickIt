package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Infrastructure.NoteManager;

public class DeleteConfirm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel deletePanel;
	
	public DeleteConfirm(NoteManager manager, int noteId) {
		deletePanel = new JPanel();
		deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.PAGE_AXIS));
		JPanel labelPane = new JPanel();
		JPanel confirmPane = new JPanel();
		
		JLabel warningLabel = new JLabel("Are you sure you want to delete?");
		labelPane.add(warningLabel);
		deletePanel.add(labelPane);
		
		JButton cancelButton = new JButton("Cancel");
		JButton deleteButton = new JButton("Delete");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				closeWindow();
				
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				manager.deleteNote(noteId);
				closeWindow();
			}
		});

		confirmPane.add(cancelButton);
		confirmPane.add(deleteButton);
		deletePanel.add(confirmPane);
		
		this.add(deletePanel);
		this.pack();
		this.setVisible(true);
	}
	
	private void closeWindow() {
		this.dispose();
	}
}

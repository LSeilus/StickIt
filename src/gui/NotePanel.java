package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import Infrastructure.Note;


public class NotePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int noteId;
	JPopupMenu notePopup;


	public NotePanel(int noteId, Note note) {
		this.noteId = noteId;
		String noteContent = note.getNoteText();
		int rows = 1 + (noteContent.length() / 70);
		String singleLine = "";
		int cutPoint = 0;
		if (rows == 1) {
			singleLine = noteContent;
			JLabel noteText = new JLabel(singleLine);
			//System.out.println(singleLine);
			noteText.setForeground(Color.WHITE);
			noteText.setBackground(Color.BLACK);
			this.add(noteText);
		}
		else if (rows > 1) {

			for (int i = 0; i < rows; i++) {

				for (int j = Math.min(70*(i+1), noteContent.length()-1); j > 70 * i; j--) {
					if (i == rows - 1) {
						singleLine = noteContent.substring(cutPoint, noteContent.length()-1);
						break;
					}
					if (noteContent.charAt(j) == ' ') {
						singleLine = noteContent.substring(cutPoint, j);
						cutPoint = j + 1;
						break;
					}
					
				}
				
				JLabel noteText = new JLabel(singleLine);
				noteText.setForeground(Color.WHITE);
				noteText.setBackground(Color.BLACK);
				this.add(noteText);

			}
			
		}
		
		
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		
		notePopup = addNotePopup();
		this.setComponentPopupMenu(notePopup);
		this.add(notePopup);
	}
	
	private JPopupMenu addNotePopup() {
		//popup menu gives GUI controls for single note
		JPopupMenu popup = new JPopupMenu();
		JMenuItem editNote = new JMenuItem("Edit");
		editNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editChosen();
			}
			
		});
		JMenuItem deleteNote = new JMenuItem("Delete");
		deleteNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteChosen();
			}
		});
		popup.add(editNote);
		popup.add(deleteNote);
		
		return popup;
	}

	private void deleteChosen() {
		//TODO
	}
	
	private void editChosen() {
		//TODO
	}
}

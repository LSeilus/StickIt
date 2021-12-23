package gui;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import Infrastructure.Note;
import Infrastructure.NoteManager;

public class NotePainter {
	public static void paintNotes(NoteManager manager, JPanel canvas, int fontSize, Color fontColor, Color bgColor) {

		canvas.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		
		int positionY = 0;
		int rows = 1;
		for (int i = manager.getNotesList().size() - 1; i >= 0; i--) {
			cons.gridwidth = 8;
			cons.weightx = 0.8;
			cons.weighty = 1;
			cons.anchor = GridBagConstraints.NORTHWEST;
			cons.gridy = positionY;
			cons.gridx = 0;
			cons.insets = new Insets(5, 10, 5, 10);
			Note currentNote = manager.getNotesList().get(i);
			rows = 1 + (currentNote.getNoteText().length() / 70); 
			cons.gridheight = rows;
			
			NotesDisplayPanel singleNote = new NotesDisplayPanel(i, currentNote, fontSize, fontColor, bgColor, manager);
			
			
			positionY += rows;
			canvas.add(singleNote, cons);
			
			cons.gridwidth = 1;
			cons.weightx = 0.1;
			cons.anchor = GridBagConstraints.NORTHEAST;
			cons.gridx = 8;
			NotesDisplayPanel catPanel = new NotesDisplayPanel(i, currentNote, fontSize, fontColor, bgColor, false);
			canvas.add(catPanel, cons);
			cons.gridx = 9;
			NotesDisplayPanel datePanel = new NotesDisplayPanel(i, currentNote, fontSize, fontColor, bgColor, true);

			canvas.add(datePanel, cons);
		}
	}
}

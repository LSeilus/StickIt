package gui;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import Infrastructure.Note;
import Infrastructure.NoteManager;

public class NotePainter {
	public static void paintNotes(NoteManager manager, JPanel canvas, int fontSize, Color fontColor, Color bgColor) {

		canvas.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridwidth = 8;
		cons.weightx = 0.8;
		cons.weighty = 1;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.insets = new Insets(0, 10, 0, 10);
		cons.gridx = 0;
		int positionY = 0;
		int rows = 1;
		for (int i = 0; i < manager.getNotesList().size(); i++) {
				
			Note currentNote = manager.getNotesList().get(i);
			NotePanel singleNote = new NotePanel(i, currentNote, fontSize, fontColor, bgColor, manager);
			rows = 1 + (currentNote.getNoteText().length() / 70); 

			cons.gridheight = rows;
			cons.gridy = positionY;
			positionY += rows;
			canvas.add(singleNote, cons);
		}
	}
}

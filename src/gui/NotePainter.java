package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import Infrastructure.Note;

public class NotePainter {
	public static void paintNotes(ArrayList<Note> notes, JPanel canvas) {
		
		//int singleNoteHeight = (int) Math.floor(1.0 * (canvas.getHeight() - 20) / notes.size());
		//Layout ensures that new notes are placed accordingly and do not overlap
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
		for (int i = 0; i < notes.size(); i++) {
			
			
			
			Note currentNote = notes.get(i);
			NotePanel singleNote = new NotePanel(i, currentNote);
			rows = 1 + (currentNote.getNoteText().length() / 70); 
			//singleNote.setMaximumSize(new Dimension(canvas.getWidth() - 10, singleNoteHeight));
			//singleNote.setMinimumSize(new Dimension(canvas.getWidth() - 10, singleNoteHeight));
			
			cons.gridheight = rows;
			cons.gridy = positionY;
			positionY += rows;
			canvas.add(singleNote, cons);
		}
	}
}

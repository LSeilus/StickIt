package Infrastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class NoteManager {
	
	private String noteFilePath;
	private LinkedList<Note> notesList;
	
	public LinkedList<Note> loadNotes() {
		BufferedReader bReader = null;
		String line = "";
		LinkedList<Note> notesList = new LinkedList<Note>();
		try {
			bReader = new BufferedReader(new FileReader(noteFilePath));
			while ((line = bReader.readLine()) != null) {
				String[] noteRawData = line.split(",");

				LocalDateTime date = LocalDateTime.parse(noteRawData[2]);
				Note note = new Note(noteRawData[0], noteRawData[1], date);
				notesList.add(note);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return notesList;

	}
	
	public void addNote(LinkedList<Note> list, String text, String category) {
		Note note = new Note(text, category, LocalDateTime.now());
		list.add(note);
		rewriteNoteFile();
	}
	
	public void editNote(int noteId, String newText, String newCategory) {
		if (!newText.isEmpty()) {
			notesList.get(noteId).editNoteText(newText);
		}
		if (!newCategory.isEmpty()) {
			notesList.get(noteId).editNoteCategory(newCategory);
		}
		rewriteNoteFile();
	}
	
	public void deleteNote(int noteId) {
		notesList.remove(noteId);
		rewriteNoteFile();
	}
	
	private void rewriteNoteFile() {
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\notes2.csv"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Note> noteIterator = notesList.Iterator();
	}

	public LinkedList<Note> getNotesList() {
		return notesList;
	}

	public void setNotesList(LinkedList<Note> notesList) {
		this.notesList = notesList;
	}

	public NoteManager() {
		this.noteFilePath = System.getProperty("user.dir") + "\notes.csv";
		this.setNotesList(loadNotes());
	}
}

package Infrastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.ArrayList;

public class NoteManager {
	
	private String noteFilePath;
	private ArrayList<Note> notesList;
	
	public ArrayList<Note> loadNotes() {
		BufferedReader bReader = null;
		String line = "";
		ArrayList<Note> notesList = new ArrayList<Note>();
		try {
			File noteFile = new File(noteFilePath);
			if (!noteFile.exists()) {
				noteFile.createNewFile();
			}
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
	
	public void addNote(String text, String category) {
		Note note = new Note(text, category, LocalDateTime.now());
		notesList.add(note);
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
		String tempFilePath = System.getProperty("user.dir") + "/notes2.csv";
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(tempFilePath));
			Iterator<Note> notesIterator = notesList.iterator();
				String line = "";
				Note noteWrite = null;
				while (notesIterator.hasNext()) {
					noteWrite = notesIterator.next();
					line = noteWrite.getNoteText() + "," + noteWrite.getNoteCategory() + "," + noteWrite.getInitDate().toString();
					bWriter.write(line);
					bWriter.newLine();
				}
			bWriter.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		File original = new File(noteFilePath);
		original.delete();
		File rewritten = new File(tempFilePath);
		rewritten.renameTo(original);
	}

	public ArrayList<Note> getNotesList() {
		return notesList;
	}

	public void setNotesList(ArrayList<Note> notesList) {
		this.notesList = notesList;
	}

	public NoteManager() {
		this.noteFilePath = System.getProperty("user.dir") + "/notes.csv";
		this.setNotesList(loadNotes());
	}
}

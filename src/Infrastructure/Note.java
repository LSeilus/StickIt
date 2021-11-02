package Infrastructure;

import java.time.LocalDateTime;

public class Note {
	private String noteText;
	private String noteCategory;
	private LocalDateTime initDate;
	
	public Note(String text, String category, LocalDateTime date) {
		this.editNoteText(text);
		this.editNoteCategory(category);
		this.setModDate(date);
	}

	public String getNoteText() {
		return noteText;
	}

	public void editNoteText(String noteText) {
		this.noteText = noteText;
	}

	public String getNoteCategory() {
		return noteCategory;
	}

	public void editNoteCategory(String noteCategory) {
		this.noteCategory = noteCategory;
	}

	public LocalDateTime getInitDate() {
		return initDate;
	}

	public void setModDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}
}

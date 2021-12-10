package gui;


import java.awt.SystemTray;
import Infrastructure.NoteManager;


public class Main {

	public static void main(String[] args) {
		NoteManager noteManager = new NoteManager();		
		NoteWindow noteWindow = new NoteWindow(noteManager);
		SystemTray stickyTray = Tray.AddTray(noteManager, noteWindow);
	}

}

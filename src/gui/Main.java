package gui;


import java.awt.SystemTray;
import Infrastructure.NoteManager;
import Infrastructure.SettingsManager;


public class Main {

	public static void main(String[] args) {
		NoteManager noteManager = new NoteManager();		
		SettingsManager settingsManager = new SettingsManager();
		NoteWindow noteWindow = new NoteWindow(noteManager, settingsManager);
		noteManager.setWindow(noteWindow);
		
		@SuppressWarnings("unused")
		SystemTray stickyTray = Tray.AddTray(noteManager, noteWindow);
	}

}

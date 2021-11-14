package gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import Infrastructure.Note;

import java.awt.PopupMenu;
import java.awt.MenuItem;
import Infrastructure.NoteManager;
public class Main {

	public static void main(String[] args) {
		NoteManager noteManager = new NoteManager();
		ArrayList<String> categories = new ArrayList<String>();
		Iterator<Note> iterator = noteManager.getNotesList().iterator();
		while(iterator.hasNext()) {
			boolean same = false;
			for (int i = 0; i < categories.size(); i ++) {
				if (iterator.next().getNoteCategory() == categories.get(i)) {
					same = true;
				}
			}
			if (same == false) {
				categories.add(iterator.next().getNoteCategory());
			}
		}
		NoteWindow noteWindow = new NoteWindow();
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage("Z:\\eclipseWorkspace\\StickIt\\images\\trayicon.png");
			PopupMenu trayPopup = new PopupMenu();
			MenuItem quitProgramMenu = new MenuItem("Quit");
			quitProgramMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			MenuItem addNoteMenu = new MenuItem("Add Note");
			addNoteMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AddNoteWindow addNoteW = new AddNoteWindow(categories.toArray(new String[0])); 
				}
				
			});
			MenuItem openSettingsMenu = new MenuItem("Settings");
			
			
			trayPopup.add(addNoteMenu);
			trayPopup.add(openSettingsMenu);
			trayPopup.add(quitProgramMenu);
			TrayIcon icon = new TrayIcon(image, "StickIt", trayPopup);
			try { 
				tray.add(icon);
			}
			catch(AWTException e){
				e.printStackTrace();
			}
			
		}
	}

}

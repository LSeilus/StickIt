package gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Infrastructure.NoteManager;

public class Tray {
	static SystemTray AddTray(NoteManager manager, NoteWindow noteWindow) {
		
		if (SystemTray.isSupported()) {
			//Create tray icon with popup menu
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage("Z:\\eclipseWorkspace\\StickIt\\images\\trayicon.png");
			PopupMenu trayPopup = new PopupMenu();
			//Quitting from tray is necessary
			MenuItem quitProgramMenu = new MenuItem("Quit");
			quitProgramMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			//Add note, close add note window, 
			MenuItem addNoteMenu = new MenuItem("Add Note");
			addNoteMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AddNoteWindow addNoteW = new AddNoteWindow(manager.getCategories().toArray(new String[0]), manager, noteWindow); 
				}
				
			});
			//allows for some cosmetic changes
			MenuItem openSettingsMenu = new MenuItem("Settings");
			openSettingsMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				 //TODO 	
				}
			});
			
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
			return tray;
		}
		else {
			return null;
		}
	}	
}
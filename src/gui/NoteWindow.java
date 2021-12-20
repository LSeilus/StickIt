package gui;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import Infrastructure.NoteManager;
import Infrastructure.SettingsManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NoteWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	SettingsManager settingsManager;
	NoteManager noteManager;
	Color bgColor;
	Color fontColor;
	int fontSize;
	
	public NoteWindow(NoteManager noteManager, SettingsManager settingsManager){
		this.bgColor = new Color(settingsManager.getBgColorRGB());
		this.fontColor = new Color(settingsManager.getFontColorRGB());
		this.fontSize = settingsManager.getFontSize();
		
		this.noteManager = noteManager;
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		panel = createPanel();
		this.add(panel);
		ComponentResizer resizer = new ComponentResizer();
		resizer.registerComponent(this);
		ComponentMover mover = new ComponentMover();
		mover.setDragInsets(new Insets(5, 5, 5, 5));
		mover.registerComponent(this);
		this.pack();
		this.setVisible(true);
		this.settingsManager = settingsManager;
	}
	
	
	public void redraw() {
		this.bgColor = new Color(settingsManager.getBgColorRGB());
		this.fontColor = new Color(settingsManager.getFontColorRGB());
		this.fontSize = settingsManager.getFontSize();
		this.remove(panel);
		panel = createPanel();
		this.add(panel);
		this.pack();
	}
	
	private JPanel createPanel() {
		JPanel newPanel = new JPanel();
		newPanel.setMinimumSize(new Dimension(100, 200));
		newPanel.setBackground(bgColor);
		NotePainter.paintNotes(noteManager, newPanel, fontSize, fontColor, bgColor);
		return newPanel;
	}

}

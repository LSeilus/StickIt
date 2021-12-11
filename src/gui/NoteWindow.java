package gui;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import Infrastructure.NoteManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NoteWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	
	public NoteWindow(NoteManager manager){
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		panel = createPanel(manager);
		this.add(panel);
		ComponentResizer resizer = new ComponentResizer();
		resizer.registerComponent(this);
		ComponentMover mover = new ComponentMover();
		mover.setDragInsets(new Insets(5, 5, 5, 5));
		mover.registerComponent(this);
		
		this.pack();
		this.setVisible(true);
			
	}
	
	
	public void redraw(NoteManager manager) {
		this.remove(panel);
		panel = createPanel(manager);
		this.add(panel);
		this.pack();
	}
	
	private JPanel createPanel(NoteManager manager) {
		JPanel newPanel = new JPanel();
		newPanel.setMinimumSize(new Dimension(100, 200));
		newPanel.setBackground(Color.black);
		NotePainter.paintNotes(manager.getNotesList(), newPanel);
		return newPanel;
	}

}

package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SettingsWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel settingsPanel;
	private NoteWindow noteWindow;
	
	public SettingsWindow(NoteWindow noteWindow) { 
		this.noteWindow = noteWindow;
		settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.anchor = GridBagConstraints.WEST;
		cons.insets = new Insets(0, 20, 0, 20);
		JLabel bgLabel = new JLabel("Background Color");
		settingsPanel.add(bgLabel, cons);
		
		cons.gridy = 6;
		JLabel fontLabel = new JLabel("Font Color");
		settingsPanel.add(fontLabel, cons);

		cons.gridy = 1;
		cons.gridwidth = 4;
		cons.gridheight = 4;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.insets = new Insets(0, 10, 20, 10);
		JColorChooser bgChooser = new JColorChooser();
		bgChooser.setPreviewPanel(new JPanel());
		settingsPanel.add(bgChooser, cons);
		

		cons.gridy = 7;
		JColorChooser fontChooser = new JColorChooser();
		fontChooser.setPreviewPanel(new JPanel());

		settingsPanel.add(fontChooser, cons);

		cons.gridx = 0;
		cons.gridy = 12;
		cons.gridwidth = 2;
		cons.gridheight = 1;
		cons.weightx = 0.3;
		JLabel fontSizeLabel = new JLabel("Font Size:");
		settingsPanel.add(fontSizeLabel, cons);

		cons.gridx = 1;
		cons.weighty = 0.3;
		ArrayList<Integer> fonts = new ArrayList<Integer>();
		for (int i = 7; i < 73; i ++) {
			if (i < 12 && i % 2 == 1) {
				fonts.add(i);
			};
			if (i % 2 == 0) {
				fonts.add(i);
			}
		}
		JComboBox<Integer> fontSizeField = new JComboBox<Integer>(fonts.toArray(new Integer[0]));
		fontSizeField.setPrototypeDisplayValue(11);
		fontSizeField.setSelectedIndex(4);
		settingsPanel.add(fontSizeField, cons);
		
		cons.gridx = 2;
		cons.gridy = 12;
		cons.gridwidth = 2;
		cons.gridheight = 1;
		cons.weightx = 0.4;
		cons.weighty = 0.3;
		cons.anchor = GridBagConstraints.EAST;
		JButton confirm = new JButton("Save and close");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				noteWindow.settingsManager.setSettings(Integer.valueOf(fontSizeField.getSelectedItem().toString()), bgChooser.getColor().getRGB(), fontChooser.getColor().getRGB());
				noteWindow.redraw();
				closeWindow();
				
			}
		});
		settingsPanel.add(confirm, cons);
		
		this.add(settingsPanel);
		this.pack();
		this.setVisible(true);
	}
	
	private void closeWindow() {
		this.dispose();
	}
}

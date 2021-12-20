package Infrastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SettingsManager {
	
	private String settingsFile;
	private int fontSize;
	private int fontColorRGB;
	private int bgColorRGB;
	
	private void loadSettings() {
		BufferedReader bReader = null;
		String line = "";
		ArrayList<String> settings = new ArrayList<String>();
		try {
			File noteFile = new File(settingsFile);
			if (!noteFile.exists()) {
				noteFile.createNewFile();
			}
			
			bReader = new BufferedReader(new FileReader(settingsFile));
			while ((line = bReader.readLine()) != null) {
				settings.add(line);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//cast all settings to ints for later use
		if (settings.size() >= 3) {
			try {
				fontSize = Integer.valueOf(settings.get(0));
				fontColorRGB = Integer.valueOf(settings.get(1));
				bgColorRGB = Integer.valueOf(settings.get(2));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		// this applies if the user hasn't changed settings at all
		else {
			fontSize = 12;
			fontColorRGB = -1;
			bgColorRGB = -16777216;
		}
		
	}
	
	public SettingsManager() {
		this.settingsFile = System.getProperty("user.dir") + "/settings.csv";
		loadSettings();
	}
	
	public void setSettings(int fontSize, int bgColorRGB, int fontColorRGB) {
		this.fontSize = fontSize;
		this.bgColorRGB = bgColorRGB;
		this.fontColorRGB = fontColorRGB;
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(settingsFile, false));
			bWriter.write(Integer.toString(fontSize));
			bWriter.newLine();
			bWriter.write(Integer.toString(fontColorRGB));
			bWriter.newLine();
			bWriter.write(Integer.toString(bgColorRGB));
			bWriter.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int getFontSize() {
		return fontSize;
	}

	
	public int getFontColorRGB() {
		return fontColorRGB;
	}

	public int getBgColorRGB() {
		return bgColorRGB;
	}

}

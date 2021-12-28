# Stickit
### Video Demo:  https://youtu.be/lOOBsXhAlzk
### Description:
It's a simple program for writing notes, intended for Windows systems. It allows for adding, editing, and deleting notes, keeping their content, category,
and creation date in a .csv file. Settings - for now those include only font size, font color, and background color - are similarly stored in a csv file.
While the program is written in Java, it makes use of the system tray, so it will not work properly on operating systems who lack that feature. 
The notes are displayed in orded by date created from the top. Editing notes does not change their creation date. 


The two packages are divided by primary function, wtih the 'gui' package housing classes that deal with frames and panels,
while the 'infrastructure' package deals primarily with writing/reading data.

#### Classes:
**gui:**

Main - the class only calls initial constructors, and otherwise has no function

NoteWindow - creates a window onto which notes will be written. A monocolored undecorated panel, making use of the ComponentMover and ComponentResizer classes
for moving and resizing functionality, and calls NotePainter to populate the panel.

ComponentMover, ComponentResizer - both classes are of Rob Camick's authorship, and allow moving and resizing functionality for undecorated windows.

NotePainter - a class with only one static method, that iterates over all the notes and creates a NoteDisplayPanel instance for each of them, and  their categories and dates, according to a set GridBagLayout. 

NoteDisplayPanel - a class that creates a panel with labels that display the notes. Depending on constructor, different results are given for note text, category, and creation date. Probably the part of the program I'm most unsatisfied with, due to the very rigid treatment of long notes and categories. Ideally, line length would automatically adjust to fill out the window space, but it's not the case. Each note panel (not date or category panel) also holds a mouse listener - right clicking a note's text allows for editing or deletion of said note.

Tray - a feature that makes up for the main window's undecorated property. Allows for adding new notes, editing settings, and quitting the program. It achieves those means by using a popup menu with appropriate listeners.

NoteInputWindow - A window that allows for adding or editing notes, depending on the constructor. Instances of it are created through NoteDisplayPanel or Tray, for editing or adding respectively. Pressing the button to add or edit a note disposes of the window.

DeleteConfirm - A very simple window that pops up when the user elects to delete a note, asking for confirmation. Depending on which of the two buttons are pressed, a note will be deleted or not. The window is then disposed regardless.

SettingsWindow - A window that makes use of Java's built-in JColorChooser to control the color of the font and the color of the background. It also holds a simple combo box to change the font size. Ideally, many more settings will be added in the future, such as the sorting method for notes, the font (not just its size) and more.

**infrastructure:**

Note - A very simple class that only acts as a structure for holding values of a note - its text, category, and creation date.

NoteManager - A class performs all the operations on notes, and the csv file for holding the notes. Adding, editing, and deleting notes will all trigger a rewriting of the csv file, ensuring that the user needs not worry about saving any data manually. If a note file is not found, it will be created in the program's directory.

SettingsManager - A class that is responsible for storing and editing settings, and for writing those to file. For now only 3 settings are recognized, and while those have separate getters, there is a single method that acts as a setter, and will also overwrite the settings file each time it's called. As above, if a settings file is not found, it will be created.

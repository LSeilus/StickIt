# Stickit
### Video Demo:  <https://youtu.be/lOOBsXhAlzk
### Description:
It's a simple program for writing notes, intended for Windows systems. It allows for adding, editing, and deleting notes, keeping their content, category,
and creation date in a .csv file. Settings - for now those include only font size, font color, and background color - are similarly stored in a csv file.
While the program is written in Java, it makes use of the system tray, so it will not work properly on operating systems who lack that feature. 
The notes are displayed in orded by date created from the top. Editing notes does not change their creation date. 


The two packages are divided by primary function, wtih the 'gui' package housing classes that deal with frames and panels,
while the 'infrastructure' package deals primarily with writing/reading data.

####Classes:
**gui:**
Main - the class only calls initial constructors, and otherwise has no function
NoteWindow - creates a window onto which notes will be written. A monocolored undecorated panel, making use of the ComponentMover and ComponentResizer classes
for moving and resizing functionality, and calls NotePainter to populate the panel.
ComponentMover, ComponentResizer - both classes are of Rob Camick's authorship, and allow moving and resizing functionality for undecorated windows.
NotePainter - a class with only one static method, that iterates over all the notes and creates a NoteWindow instance for each of them, and  their categories and dates,
according to a set GridBagLayout. 
NoteWindow - a class that creates a pa

Rob Camick

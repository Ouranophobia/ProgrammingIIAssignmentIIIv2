# ProgrammingIIAssignmentIIIv2

Write a Java program to imitate a file system of an operating system. 

Design a class called BasicFile with options to carry out the following operations: 

1.	Select and open an input file using a file dialog box.

2.	Make a copy of the file, whether it is a text file or an image file.

3.	Write to an output file with the option of either appending to the file, or over-writing the contents of the file.

4.	Display the following attributes of the input file in a scrollable screen:
i.	The absolute path of the file
ii.	Files and directories that are in the path of the file.
iii.	The size of the file in kilobytes.
iv.	The number of lines in the file, if the is a text file.

5.	Display the contents of the input file in a scrollable pane.  

6.	Search the input file line by line for a given string. The output must contain the line number, followed by the contents of the line that contains the search argument. For instance given the following the search string:  Java, the program would search the file line by line generating a result such as the following:
50:  on the island of Java
95:  The people of JAVA loves jaVa.
 
Use recursion to search the file.

7.	Tokenize the input file so that program recognizes all printable characters on the keyboard.

You may utilize the classes BasicFile and TestBasicFile as a source of reference. 


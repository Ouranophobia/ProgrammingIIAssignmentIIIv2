
package programmingiiassignmentiii;

import javax.swing.JFileChooser;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class BasicFile {
    File f;
		
    public BasicFile()
    {
        
        JFileChooser choose = new JFileChooser();
	int status = choose.showOpenDialog(null);
				
	try{
	if (status != JFileChooser.APPROVE_OPTION) 
	throw new IOException();
	
            f = choose.getSelectedFile();
	
        if (!f.exists()) 
	throw new FileNotFoundException();
        }
	
        catch(FileNotFoundException e){
            display(e.toString(), "File not found ....");
            }
	
        catch(IOException e){
            display(e.toString(),  "Approve option was not selected");
            }

    }
    
    public String getContents(){
       return "Selected file: " + f.getAbsolutePath();
       
    }
		
    void display(String msg, String s){
	    JOptionPane.showMessageDialog(null, msg, s, JOptionPane.ERROR_MESSAGE);
            }

    public String getFileSize() {
        double bytes = f.length();
        double kilobytes = (bytes / 1024);
   
        return "File Size: " + kilobytes + " kilobtyes.";
    }

    public String getName() {
        return f.getName();
    }

    public String getPath() {
        return "File Path: " + f.getAbsolutePath();
    }
    
    public void copy() throws IOException{
       
        InputStream inStream;
	OutputStream outStream;
		
    	try{
    		
    	    File file1 =new File(f.getName());
    	    File file2 =new File("Copy of " + f.getName());
    		
    	    inStream = new FileInputStream(file1);
    	    outStream = new FileOutputStream(file2);
        	
    	    byte[] buffer = new byte[1024];
    		
    	    int length;
    	   
    	    while ((length = inStream.read(buffer)) > 0){
    	  
    	    	outStream.write(buffer, 0, length);
    	 
    	    }
    	 
    	    inStream.close();
    	    outStream.close();
    	      
    	    JOptionPane.showMessageDialog(null, "Filed copied successfully!");
    	    
    	}
        
        catch(IOException e){
    	}
   
    }
    
    public void open(){
        try {
            String s = '"' + f.getAbsolutePath() + '"';
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("notepad " + s);
        } catch (IOException ex) {
            Logger.getLogger(BasicFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void append(){
        String s = JOptionPane.showInputDialog(null, "What would you like to append to the file?");
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f.getName(), true)))) {
        out.println("\n" +s);
        }
        catch (IOException e) {
        }
        JOptionPane.showMessageDialog(null, "File successfully appended to!");
    }
	
    public void overwrite() throws FileNotFoundException{
        String s = JOptionPane.showInputDialog(null, "What would you like to overwrite the file with?");
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f.getName(), false)))) {
        out.println("\n" +s);
        }
        catch (IOException e) {
        }
        JOptionPane.showMessageDialog(null, "File successfully overwritten!");  
    }
    
    public void showContent() throws IOException{
        BufferedReader br = null;
         try {
            br = new BufferedReader(new FileReader(f.getName()));
            final JTextArea textArea = new JTextArea(15, 30);

            textArea.read(br, null);

            JOptionPane.showMessageDialog(null, new JScrollPane(textArea));
             } 
       
         catch (FileNotFoundException e) {
         }
        
         catch (IOException e) {
         } 
         finally {
            if (br != null) {
               try {
                  br.close();
               } 
               
               catch (IOException e){
               }
            
            }
         }
    }
    public void search() throws FileNotFoundException{
        String s = JOptionPane.showInputDialog(null, "Enter word to search for.");
        Scanner scnr = null;
        
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(f.getName()));
            int linecount = -1;
            String line;

            System.out.println("Searching for " + s + " in " + f.getName() + "...");

            while (( line = bf.readLine()) != null){
                linecount++;
                if(line.contains(s))
                JOptionPane.showMessageDialog(null, linecount + ": " + line);
                
            }
            
        bf.close();
        
        }
    catch (IOException e){
        System.out.println("IO Error Occurred: " + e.toString());
    }
  
    }
    
}

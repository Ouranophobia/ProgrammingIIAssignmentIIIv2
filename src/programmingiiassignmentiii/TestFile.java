
package programmingiiassignmentiii;

import javax.swing.JOptionPane;
import java.io.IOException;

public class TestFile {
    public static void main(String[] arg) throws IOException{
	
        boolean done = false;
        BasicFile f;

	String menu = "Enter option\n1. Open File\n2. Copy File\n3. Append/Overwrite File\n4. Display File Info\n5. Display Content\n6. Search File\n7. Quit";
	while(!done){
            
            String s = JOptionPane.showInputDialog( menu);
			
            try{
		int i = Integer.parseInt(s);
		switch(i){
		
                    case 1:
                    f = new BasicFile();
                    f.open();
                    break;
                        
                    case 2:
                        f = new BasicFile();
                        f.copy();
                        break;
                        
                    case 3:
                        f = new BasicFile();
                        String a = JOptionPane.showInputDialog(null, "Would you like to APPEND to this file or OVERWRITE?\n1. Append\n2. Overwrite");
                        int x = Integer.parseInt(a);
                        
                        switch(x){
                            
                            case 1:
                                f.append();
                                break;
                                
                            case 2:
                                f.overwrite();
                                break;
                                
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid choice.");
                        }
                        break;
                        
                    case 4:
                        f = new BasicFile();
                        display(f);
                        break;
                        
                    case 5: 
                        f = new BasicFile();
                        f.showContent();
                        break;
                        
                    case 6:
                        f = new BasicFile();
                        f.search();
					 
                    case 7:
			done = true;
			break;
		
                    default:
			display("This option is underfined", "Error");
			break;
			}
           }
            
           catch(NumberFormatException | NullPointerException e){
				display(e.toString(), "Error"); 
           }
            
        }
        
	}

	static void display(String s, String err){
		JOptionPane.showMessageDialog(null, s, err, JOptionPane.ERROR_MESSAGE);
	}
	
        static void display(String s){
		JOptionPane.showMessageDialog(null, s, "Content", JOptionPane.ERROR_MESSAGE);
	}
        
	static void display(BasicFile f){
		String s = f.getFileSize() + "\n" + f.getPath();
		String fn = f.getName();
		JOptionPane.showMessageDialog(null, s , "Filename: " + fn, JOptionPane.INFORMATION_MESSAGE);
	}
        
}

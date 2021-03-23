package dd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class DecisionDiagram {
	public static void main(String argv[]) {
		JFrame frame = new JFrame("Student life");
		int q = 0; // Current question
		while(true) {
		  switch(q) {
		  case 0: {
		    String[] prim = new String[] {
		    	"The main thing is to have the best time of my life","Student life? I am interested in the curriculum and the degree"
		    };
		    String answer = (String) JOptionPane.showInputDialog(frame, 
		    				         "How do you imagine your student life",
		    				         "How do you imagine your student life",
		    				         JOptionPane.QUESTION_MESSAGE, 
		    				         null, 
		    				         prim, 
		    				         prim[0]);
		    if(answer.equals("The main thing is to have the best time of my life")) q = 1;
		    if(answer.equals("Student life? I am interested in the curriculum and the degree")) q = 5;
		    break;
		  }
		  case 1: {
		    String[] prim = new String[] {
		    	"A: Nice well-paying job","B: Lowly scum living in the streets","C: Make some money right now"
		    };
		    String answer = (String) JOptionPane.showInputDialog(frame, 
		    				         "And what does the beginning of your dream career look like",
		    				         "And what does the beginning of your dream career look like",
		    				         JOptionPane.QUESTION_MESSAGE, 
		    				         null, 
		    				         prim, 
		    				         prim[0]);
		    if(answer.equals("A: Nice well-paying job")) q = 3;
		    if(answer.equals("B: Lowly scum living in the streets")) q = 4;
		    if(answer.equals("C: Make some money right now")) q = 2;
		    break;
		  }
		  case 3: {
		    JOptionPane.showMessageDialog(frame,"Be a student");
		    return;
		  }
		  case 5: {
		    JOptionPane.showMessageDialog(frame,"Not implemented yet");
		    return;
		  }
		  case 4: {
		    JOptionPane.showMessageDialog(frame,"Don't be a student");
		    return;
		  }
		  case 2: {
		    JOptionPane.showMessageDialog(frame,"Go get a job then instead of studying");
		    return;
		  }
		  }
		}
	}
}

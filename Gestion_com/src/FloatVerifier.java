import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FloatVerifier extends InputVerifier {
        public boolean verify(JComponent input) {
	       JTextField tf = (JTextField) input;
	       String content = tf.getText();
	       return isValid(content);
        }
    
 
public boolean isValid(String s){
		try{
		float flo = new Float(s);
		return true;
		}
		catch(NumberFormatException n){
 
			JOptionPane.showMessageDialog(null, 
       	         "Il faut entrer un nombre ",
       	         "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
}}
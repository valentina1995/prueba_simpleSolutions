package controler;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class MyInputVerifier extends InputVerifier {

	@Override
	public boolean verify(JComponent input) {
			String text = ((JTextField) input).getText();
            int num;
            try {
                num = Integer.parseInt(text);
            } catch (NumberFormatException e) {
            	System.err.println("No se puede convertir a numero");
            	e.printStackTrace();
                return false;
            }
            if (num <= 0 && num >= 100000)
                return true;
            
            return false;

	}
}
	

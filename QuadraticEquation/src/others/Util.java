/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package others;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Home
 */
public class Util {
    
    	private TextField tfa = new TextField();
	private TextField tfb = new TextField();
	private TextField tfc = new TextField();
	private TextField tfroots = new TextField();
	private Button btsolve = new Button("Solve");
    
private void calculateEquation(){
		double a = Double.parseDouble(tfa.getText());
		double b = Double.parseDouble(tfb.getText());
		double c = Double.parseDouble(tfc.getText());
		
		if (a == 0 && b == 0 && c == 0){
			tfroots.setText("All x");
		}
		else if (a==0 && b==0 && c!= 0){
			tfroots.setText("No x");
		}
		else if (a==0 && b!= 0){
			double x = -c/b;
			tfroots.setText(String.format("%.1f", x));
		}
		else if (a!= 0){
			double discriminant = b*b - 4*a*c;
			if (discriminant < 0){
				tfroots.setText("No x");
			}
			else if (discriminant == 0){
				double x = -b/2*a;
				tfroots.setText(String.format("%.1f", x));
			}
			else if (discriminant > 0){
				double x = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
				double x2 = (-b - Math.sqrt(b*b - 4*(a*c)))/(2*a);
				tfroots.setText(String.format("%.1f, %.1f", x,x2));
			}
		}	
	}
    
}

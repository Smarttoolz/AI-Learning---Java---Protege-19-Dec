// Tobel Atnafu
// This program takes in the 3 coefficients of a quadratic equation using a GUI and solves for X. Finally it displays the solution

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class QuadraticSolver extends Application {
	
	private TextField tfa = new TextField();
	private TextField tfb = new TextField();
	private TextField tfc = new TextField();
	private TextField tfroots = new TextField();
	private Button btsolve = new Button("Solve");
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bpane = new BorderPane();
	    HBox hBox = new HBox(15);
	    hBox.setPadding(new Insets(15, 15, 15, 15));
	    tfa.setPrefColumnCount(5);
	    tfb.setPrefColumnCount(5);
	    tfc.setPrefColumnCount(5);
	    tfroots.setEditable(false);
		hBox.getChildren().addAll(new Label("a: "),tfa,new Label("b: "),tfb,new Label("c: "),tfc,new Label("Roots of ax\u00B2 + bx + c "),tfroots);
		
		HBox hBox2 = new HBox(15);
		hBox2.setPadding(new Insets(15, 15, 15, 15));
		hBox2.getChildren().add(btsolve);
		hBox2.setAlignment(Pos.CENTER);
		bpane.setTop(hBox);
		bpane.setCenter(hBox2);
		
		btsolve.setOnAction(e -> calculateEquation());
		
		Scene scene = new Scene (bpane);
		primaryStage.setTitle("Quadratic equation solver");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
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

	public static void main(String[] args) {
		launch(args);
		
	}
}

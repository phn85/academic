/* <h1>FileName: Main.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This file manages the look and feel of the XML pages through CSS file.
 */
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

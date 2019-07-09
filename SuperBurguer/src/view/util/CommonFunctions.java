package view.util;

import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class CommonFunctions {

//	public static Parent replaceSceneContent(Stage primaryStage, URL fxml, URL css) {
//		Parent parent = null;
//		
//		try {
//			parent = (Parent) FXMLLoader.load(fxml, null, new JavaFXBuilderFactory());
//			
//			Scene scene = primaryStage.getScene();
//			if(scene == null) {
//				scene = new Scene(parent);
//					if(css!=null) parent.getStylesheets().add(css.toExternalForm());
//					primaryStage.setScene(scene);
//			} else {
//				if(css!=null) parent.getStylesheets().add(css.toExternalForm());
//				primaryStage.getScene().setRoot(parent);
//			}
//			primaryStage.sizeToScene();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return parent;
//	}
	
	public static void swapScenes(Stage primaryStage, URL fxml, Object controller) {
		try {
			FXMLLoader loader = new FXMLLoader(fxml);
			
			loader.setController(controller);
			Parent parent = (Parent) loader.load();
			primaryStage.getScene().setRoot(parent);
		} catch (IOException ex) {
			System.err.println("Não foi possível trocar de Scene.");
			ex.printStackTrace();
		}
	}
	
}

package view.util;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public abstract class FXMLClass extends Application {
	
	private Image icon = null;
	private URL FXMLlocation = null;
	private URL CSSlocation = null;
	private Object Controller = null;
	
	private String title = null;
	
	protected static Stage primaryStage;
	
	public FXMLClass() {
		initializeElementaryVariables();
	}
	
	protected abstract void initializeElementaryVariables();
	
	@Override
	public abstract void init() throws Exception;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		if(FXMLlocation == null) {
			System.err.println("É necessário informar o 'FXML_LOCATION_SHORTCUT.'");
			System.exit(0);
		}
		
		primaryStage.setTitle(title);
		
		try {
			initializePrimaryStage(primaryStage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void initializePrimaryStage(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		
		FXMLLoader loader = new FXMLLoader(FXMLlocation);
		
		if(Controller != null)
			loader.setController(Controller);
			
		
		Parent parent = (Parent) loader.load();
		Scene scene = this.primaryStage.getScene();
		
		if(scene == null) {
			scene = new Scene(parent);
			if(CSSlocation != null)
				parent.getStylesheets().add(CSSlocation.toExternalForm());
			this.primaryStage.setScene(scene);
		} else {
			if(CSSlocation != null)
				parent.getStylesheets().add(CSSlocation.toExternalForm());
			this.primaryStage.getScene().setRoot(parent);
		}
		
		if(icon != null)
			this.primaryStage.getIcons().add(icon);
		
		this.primaryStage.sizeToScene();
		
		this.primaryStage.show();
		
		afterInitialize();
	}
	
	protected void afterInitialize() {}
	
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public void setFXMLlocation(URL fXMLlocation) {
		FXMLlocation = fXMLlocation;
	}
	
	public void setCSSlocation(URL cSSlocation) {
		CSSlocation = cSSlocation;
	}
	
	public void setController(Object controller) {
		Controller = controller;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public static Stage getStage() {
		return primaryStage;
	}
	
}

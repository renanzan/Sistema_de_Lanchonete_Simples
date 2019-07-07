package main;

import database.Database;
import database.models.Caixa;
import view.scenes.caixa.login.LoginController;
import view.util.DirectoryShortcuts;
import view.util.FXMLClass;

public class MainCaixa extends FXMLClass {
	
	public static Caixa currentUser;
	
	public static void main(String[] args) {
		if(Database.getSingletonConnection() != null) {
			launch(args);
		}
	}

	@Override
	protected void initializeElementaryVariables() {
		setFXMLlocation(DirectoryShortcuts.URL_SCENE_CAIXA_LOGIN);
		setController(new LoginController());
		setTitle("Caixa");
	}

	@Override
	public void init() throws Exception {}
	
	@Override
	protected void afterInitialize() {
//		primaryStage.setFullScreen(true);
	}
	
}

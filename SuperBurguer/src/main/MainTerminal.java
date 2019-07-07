package main;

import database.Database;
import view.scenes.terminal.pagina_inicial.PaginaInicialController;
import view.util.FXMLClass;

public class MainTerminal extends FXMLClass {
	
	public static Database database;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	protected void initializeElementaryVariables() {
		setFXMLlocation(PaginaInicialController.class.getResource("\\FXML_Pagina_Inicial.fxml"));
		setController(new PaginaInicialController());
		setTitle("Terminal");
	}

	@Override
	public void init() throws Exception {}
	
	@Override
	protected void afterInitialize() {
//		primaryStage.setFullScreen(true);
	}

}

package main;

import java.util.HashMap;

import database.Database;
import database.models.Pedido;
import database.models.Produto;
import view.scenes.terminal.pagina_inicial.PaginaInicialController;
import view.util.FXMLClass;

public class MainTerminal extends FXMLClass {
	
	public static Database database;
	public static Pedido pedido = new Pedido();

	public static void main(String[] args) {
		if(Database.getSingletonConnection() != null) {
			launch(args);
		}
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

package view.scenes.pagina_inicial;

import view.util.FXMLClass;

public class PaginaInicial extends FXMLClass {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	protected void initializeElementaryVariables() {
		setFXMLlocation(PaginaInicial.class.getResource("\\FXML_Pagina_Inicial.fxml"));
		setController(new PaginaInicialController());
		setTitle("Página Inicial");
	}
	
	@Override
	public void init() throws Exception {}
	
	@Override
	protected void afterInitialize() {
		primaryStage.setFullScreen(true);
	}

}

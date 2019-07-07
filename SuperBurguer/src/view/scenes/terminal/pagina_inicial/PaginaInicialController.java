package view.scenes.terminal.pagina_inicial;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MainTerminal;
import view.scenes.terminal.cardapio.CardapioController;
import view.util.CommonFunctions;

public class PaginaInicialController implements Initializable {
	
    @FXML
    private JFXButton btn_iniciar;
    
    public PaginaInicialController() {}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btn_iniciar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CommonFunctions.swapScenes(MainTerminal.getStage(), CardapioController.class.getResource("\\FXML_Cardapio.fxml"), new CardapioController());
			}
		});
		
	}

}

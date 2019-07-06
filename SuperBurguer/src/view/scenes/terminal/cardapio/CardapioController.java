package view.scenes.terminal.cardapio;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.MainTerminal;
import view.scenes.terminal.fragments.element_menu_cardapio.ElementMenuCardapio;
import view.scenes.terminal.pagina_inicial.PaginaInicialController;
import view.util.CommonFunctions;

public class CardapioController implements Initializable {
	
	@FXML
	private AnchorPane pane_cardapio;
	
	@FXML
	private BorderPane dialog;
	
    @FXML
    private ScrollPane scrollPaneCardapio;

    @FXML
    private VBox linearLayoutCarrinho;
    
    @FXML
    private VBox linearLayoutCardapio;

    @FXML
    private JFXButton btn_finalizar;

    @FXML
    private JFXButton btn_cancelar;
    
    @FXML
    private JFXButton btn_dialog_cancelar;
    
    @FXML
    private JFXButton btn_dialog_confirmar;
    
    public CardapioController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		pane_cardapio.setMaxWidth(Double.MAX_VALUE);
		pane_cardapio.setMaxHeight(Double.MAX_VALUE);
		
		dialog.setMaxWidth(Double.MAX_VALUE);
		dialog.setMaxHeight(Double.MAX_VALUE);
		
//		scrollPaneCardapio.setFitToWidth(true); // set content width to viewport width
		
		scrollPaneCardapio.widthProperty().addListener((obs, oldVal, newVal) -> {
		     linearLayoutCardapio.setPrefWidth(scrollPaneCardapio.getWidth() - 15);
		});
		
		initializeCardapio();
		
		btn_finalizar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.toFront();
			}
		});
		
		btn_cancelar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				CommonFunctions.swapScenes(MainTerminal.getStage(), PaginaInicialController.class.getResource("\\FXML_Pagina_Inicial.fxml"), new PaginaInicialController());
			}
		});
		
		btn_dialog_cancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pane_cardapio.toFront();
			}
		});
	}
	
	private void initializeCardapio() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				for(int cont=0; cont<10; cont++)
					linearLayoutCardapio.getChildren().add(ElementMenuCardapio.create(linearLayoutCarrinho));
			}
		});
	}

}

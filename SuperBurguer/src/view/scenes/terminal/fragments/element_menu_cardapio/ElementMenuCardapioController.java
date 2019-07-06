package view.scenes.terminal.fragments.element_menu_cardapio;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view.scenes.terminal.fragments.element_menu_carrinho.ElementMenuCarrinho;

public class ElementMenuCardapioController implements Initializable {
	
	@FXML
	private VBox _linearLayoutCarrinho;
	
	@FXML
	private AnchorPane element;
	
    @FXML
    private Label txt_nome;

    @FXML
    private Label txt_ingredientes;

    @FXML
    private Label txt_cod;

    @FXML
    private Label txt_preco_reais;

    @FXML
    private Label txt_preco_centavos;

    @FXML
    private JFXButton btn_sub;

    @FXML
    private JFXButton btn_sum;

    public ElementMenuCardapioController(VBox linearLayoutCarrinho) {
    	this._linearLayoutCarrinho = linearLayoutCarrinho;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		element.setMaxWidth(Double.MAX_VALUE);
		element.setMaxHeight(Double.MAX_VALUE);
		
		btn_sum.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				_linearLayoutCarrinho.getChildren().add(ElementMenuCarrinho.create());
			}
		});
		
	}

}

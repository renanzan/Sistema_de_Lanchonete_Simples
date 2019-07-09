package view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_produto;

import java.net.URL;
import java.util.ResourceBundle;

import database.models.Produto;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import view.scenes.caixa.cadastrar_produto.CadastrarProdutoController;

public class ElementProdutoController implements Initializable {

	private Produto produto;
	private boolean focus = false;
	
	@FXML
    private HBox element;

    @FXML
    private Label txt_nome;

    @FXML
    private Label txt_cod;

    public ElementProdutoController(Produto produto) {
    	this.produto = produto;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txt_nome.setText(produto.getNome());
		txt_cod.setText(String.valueOf(produto.getCod_produto()));
		
		element.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(!isFocus()) {
					revokeFocusAllElementsProduto();
					getFocus();
				} else
					revokeFocusAllElementsProduto();
			}
		});
	}
	
	private void revokeFocus() {
		focus = false;
		Platform.runLater(() -> element.setStyle("-fx-background-color: #FFFFFF"));
	}
	
	private void getFocus() {
		focus = true;
		Platform.runLater(() -> element.setStyle("-fx-background-color: #FF0000"));
	}
	
	private void revokeFocusAllElementsProduto() {
		for(ElementProdutoController controller : CadastrarProdutoController.listaProdutos.values())
			controller.revokeFocus();
	}
	
	public boolean isFocus() {
		return focus;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
}

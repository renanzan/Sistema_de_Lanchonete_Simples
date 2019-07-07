package view.scenes.terminal.fragments.element_menu_carrinho;

import java.net.URL;
import java.util.ResourceBundle;

import database.models.Produto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ElementMenuCarrinhoController implements Initializable {

	private Produto produto;
	private int qtd;
	
	@FXML
	private Label txt_qtd;

	 @FXML
	 private Label txt_nome;

	 @FXML
	 private Label txt_cod;
	
	public ElementMenuCarrinhoController(Produto produto, int qtd) {
		this.produto = produto;
		this.qtd = qtd;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txt_nome.setText(produto.getNome());
		txt_cod.setText(String.valueOf(produto.getCod_produto()));
		txt_qtd.setText(String.valueOf(qtd));
	}

}

package view.scenes.terminal.fragments.element_menu_cardapio;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import database.models.Produto;
import database.util.ByteArray;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.MainTerminal;
import view.scenes.terminal.fragments.element_menu_carrinho.ElementMenuCarrinho;

public class ElementMenuCardapioController implements Initializable {
	
	private Produto produto;
	
	@FXML
	private ImageView img;
	
	@FXML
	private VBox _linearLayoutCarrinho;
	
	@FXML
	private AnchorPane element;
	
    @FXML
    private Label txt_nome;

    @FXML
    private Label txt_descricao;

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

    public ElementMenuCardapioController(VBox linearLayoutCarrinho, Produto produto) {
    	this._linearLayoutCarrinho = linearLayoutCarrinho;
    	this.produto = produto;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initializeFields();
		
		element.setMaxWidth(Double.MAX_VALUE);
		element.setMaxHeight(Double.MAX_VALUE);
		
		btn_sum.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!MainTerminal.pedido.getProdutos().containsKey(produto))
					MainTerminal.pedido.getProdutos().put(produto, 1);
				else
					MainTerminal.pedido.getProdutos().put(produto, MainTerminal.pedido.getProdutos().get(produto)+1);
				
				updateCarrinho();
			}
		});
		
		btn_sub.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(MainTerminal.pedido.getProdutos().containsKey(produto))
					if(MainTerminal.pedido.getProdutos().get(produto)<=1)
						MainTerminal.pedido.getProdutos().remove(produto);
					else
						MainTerminal.pedido.getProdutos().put(produto, MainTerminal.pedido.getProdutos().get(produto)-1);
				
				updateCarrinho();
			}
		});
		
	}
	
	private void initializeFields() {
		String valor[] = String.format("%.02f", produto.getPreco()).split(",");
		
		if(produto.getImage()!=null)
			Platform.runLater(() -> img.setImage(ByteArray.parseToImage(produto.getImage())));
		
		txt_nome.setText(produto.getNome());
		txt_cod.setText(String.valueOf(produto.getCod_produto()));
		txt_descricao.setText(produto.getDescricao());
		txt_preco_reais.setText(valor[0]);
		txt_preco_centavos.setText(String.format("%02d", Integer.parseInt(valor[1])));
	}
	
	private void updateCarrinho() {
		_linearLayoutCarrinho.getChildren().clear();
		
		for(Produto produto : MainTerminal.pedido.getProdutos().keySet()) {
			_linearLayoutCarrinho.getChildren().add(ElementMenuCarrinho.create(produto, MainTerminal.pedido.getProdutos().get(produto)));
		}
	}

}

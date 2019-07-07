package view.scenes.terminal.cardapio;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import database.dao.PedidoDAO;
import database.dao.ProdutoDAO;
import database.models.Pedido;
import database.models.Produto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.MainTerminal;
import view.scenes.terminal.fragments.element_menu_cardapio.ElementMenuCardapio;
import view.scenes.terminal.fragments.element_menu_carrinho.ElementMenuCarrinho;
import view.scenes.terminal.pagina_inicial.PaginaInicialController;
import view.util.CommonFunctions;

public class CardapioController implements Initializable {
	
	@FXML
    private AnchorPane pane_cardapio;
	
	@FXML
	private AnchorPane dialog2;

    @FXML
    private ScrollPane scrollPaneCardapio;

    @FXML
    private VBox linearLayoutCardapio;
    
    @FXML
    private VBox linearLayoutDialogCarrinho;

    @FXML
    private VBox linearLayoutCarrinho;

    @FXML
    private JFXButton btn_finalizar;

    @FXML
    private JFXButton btn_cancelar;

    @FXML
    private BorderPane dialog;

    @FXML
    private Label txt_valor_total_reais;

    @FXML
    private Label txt_valor_tota_centavos;

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
				if(!MainTerminal.pedido.getProdutos().isEmpty()) {
					updateDialog();
					dialog.toFront();
				}
			}
		});
		
		btn_cancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MainTerminal.pedido = new Pedido();
				CommonFunctions.swapScenes(MainTerminal.getStage(), PaginaInicialController.class.getResource("\\FXML_Pagina_Inicial.fxml"), new PaginaInicialController());
			}
		});
		
		btn_dialog_confirmar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PedidoDAO.insert(MainTerminal.pedido);
				
				new Thread(() -> {
		            Platform.runLater(() -> dialog2.toFront());
		            try {
		                Thread.sleep(5000);
		            } catch (InterruptedException ex) {
		                ex.printStackTrace();
		            }
		            Platform.runLater(() -> dialog2.toBack());
		            Platform.runLater(() -> MainTerminal.pedido = new Pedido());
		            Platform.runLater(() -> CommonFunctions.swapScenes(MainTerminal.getStage(), PaginaInicialController.class.getResource("\\FXML_Pagina_Inicial.fxml"), new PaginaInicialController()));
		        }).start();
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
				ArrayList<Produto> produtos = ProdutoDAO.getAll();
				
				for(Produto produto : produtos) {
					linearLayoutCardapio.getChildren().add(ElementMenuCardapio.create(linearLayoutCarrinho, produto));
				}
			}
		});
	}
	
	private void updateDialog() {
		String valor[] = String.format("%.02f", MainTerminal.pedido.getPreco()).split(",");
		
		txt_valor_total_reais.setText(valor[0]);
		txt_valor_tota_centavos.setText(String.format("%02d", Integer.parseInt(valor[1])));
		
		linearLayoutDialogCarrinho.getChildren().clear();
		for(Produto produto : MainTerminal.pedido.getProdutos().keySet())
			linearLayoutDialogCarrinho.getChildren().add(ElementMenuCarrinho.create(produto, MainTerminal.pedido.getProdutos().get(produto)));
	}

}

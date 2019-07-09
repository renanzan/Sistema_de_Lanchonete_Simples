package view.scenes.caixa.pagina_inicial;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import database.dao.PedidoDAO;
import database.dao.UsuarioDAO;
import database.models.Pedido;
import database.models.Pedido.Status;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import main.MainCaixa;
import view.scenes.caixa.cadastrar_produto.CadastrarProdutoController;
import view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_vendas_a_receber.ElementVendasAReceber;
import view.util.CommonFunctions;
import view.util.DirectoryShortcuts;

public class PaginaInicialController implements Initializable {

    @FXML
    private VBox linearLayoutVendasAReceber;

    @FXML
    private VBox linearLayoutRecebidos;

    @FXML
    private JFXButton btnCadastrarProduto;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(UsuarioDAO.isGerente(MainCaixa.currentUser))
			btnCadastrarProduto.setDisable(false);
		
		initializeVendasAReceber();
		
		btnCadastrarProduto.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CommonFunctions.swapScenes(MainCaixa.getStage(), DirectoryShortcuts.URL_SCENE_CADASTRAR_PRODUTO, new CadastrarProdutoController());
			}
		});
	}
	
	private void initializeVendasAReceber() {
		new Thread(() -> {
			while(true) {
	            Platform.runLater(() -> update());
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
			}
        }).start();
	}
	
	private void update() {
		ArrayList<Pedido> pedidosPendentes = PedidoDAO.get(Status.PENDENTE);
		ArrayList<Pedido> pedidosPagos = PedidoDAO.get(Status.PAGO);
		
		linearLayoutVendasAReceber.getChildren().clear();
		for(Pedido pedido : pedidosPendentes)
			linearLayoutVendasAReceber.getChildren().add(ElementVendasAReceber.create(pedido));
		
		linearLayoutRecebidos.getChildren().clear();
		for(Pedido pedido : pedidosPagos)
			linearLayoutRecebidos.getChildren().add(ElementVendasAReceber.create(pedido));
	}

}


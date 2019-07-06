package view.scenes.caixa.pagina_inicial;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import main.MainCaixa;
import view.scenes.caixa.cadastrar_produto.CadastrarProdutoController;
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
		btnCadastrarProduto.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CommonFunctions.swapScenes(MainCaixa.getStage(), DirectoryShortcuts.URL_SCENE_CADASTRAR_PRODUTO, new CadastrarProdutoController());
			}
		});
	}

}


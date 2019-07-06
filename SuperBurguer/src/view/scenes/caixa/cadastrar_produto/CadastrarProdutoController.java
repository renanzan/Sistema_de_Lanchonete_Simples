package view.scenes.caixa.cadastrar_produto;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class CadastrarProdutoController implements Initializable {

	@FXML
    private BorderPane dialog;

    @FXML
    private TextField txtNome;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private ImageView img;

    @FXML
    private JFXButton btnDialogCadastrar;

    @FXML
    private JFXButton btnDialogCancelar;

    @FXML
    private BorderPane main;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    private JFXButton btnApagar;

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private TextField txt_busca;

    @FXML
    private VBox linearLayoutListaProdutos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.toFront();
			}
		});
		
		btnDialogCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				main.toFront();
			}
		});
		
		img.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Abrir janela para selecionar diretório de imagem...");
			}
		});
		
		txt_busca.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
			@Override
			public void handle(javafx.scene.input.KeyEvent event) {
				System.out.println("Buscar: " + txt_busca.getText());
			}
        });
		
		btnApagar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Apagar");
			}
		});
		
		btnEditar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Editar");
			}
		});
	}
    
}


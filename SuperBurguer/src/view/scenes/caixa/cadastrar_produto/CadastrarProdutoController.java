package view.scenes.caixa.cadastrar_produto;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import database.dao.ProdutoDAO;
import database.models.Produto;
import database.util.ByteArray;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import main.MainCaixa;
import view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_produto.ElementProduto;
import view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_produto.ElementProdutoController;
import view.scenes.caixa.pagina_inicial.PaginaInicialController;
import view.util.CommonFunctions;
import view.util.DirectoryShortcuts;

public class CadastrarProdutoController implements Initializable {
	
	public static HashMap<Produto, ElementProdutoController> listaProdutos = new  HashMap<>();

	private byte[] imgProduto = null;
	
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
		choiceBoxTipo.setItems(FXCollections.observableArrayList(
				Produto.TipoProduto.LANCHE.toString(),
				Produto.TipoProduto.BEBIDA.toString(),
				Produto.TipoProduto.DOCE.toString()
				));
		choiceBoxTipo.getSelectionModel().selectFirst();
		choiceBoxTipo.setTooltip(new Tooltip("Selecione o tipo do produto"));
		
		update("");
		
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
				FileChooser filechooser = new FileChooser();
				
				FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
				filechooser.getExtensionFilters().add(imageFilter);
				
			    File file = filechooser.showOpenDialog(MainCaixa.getStage().getScene().getWindow());
			    
			    if (file != null) {
			        String iconimagepath = file.getAbsolutePath();
			        img.setImage(new Image(file.toURI().toString()));
			        
					imgProduto = ByteArray.parseToByteArray(file);
					System.out.println(file.getAbsolutePath());
			    }
			}
		});
		
		txt_busca.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
			@Override
			public void handle(javafx.scene.input.KeyEvent event) {
				update(txt_busca.getText());
			}
        });
		
		btnApagar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Produto produto = null;
				
				for(ElementProdutoController controller : listaProdutos.values())
					if(controller.isFocus())
						produto = controller.getProduto();
				
				if(produto!=null) {
					ProdutoDAO.remove(produto.getCod_produto());
					txt_busca.setText("");
					update("");
				} else
					System.out.println("Selecione um produto para poder remover...");
			}
		});
		
		btnDialogCadastrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Produto produto = new Produto(
						txtNome.getText(),
						Double.parseDouble(txtPreco.getText()),
						Produto.toTipoProduto(choiceBoxTipo.getSelectionModel().getSelectedItem()),
						txtDescricao.getText(),
						imgProduto);
				
				ProdutoDAO.insert(produto);
				
				resetFields();
				update("");
				main.toFront();
			}
		});
		
		btnDialogCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				resetFields();
				main.toFront();
			}
		});
		
		btnEditar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Editar");
			}
		});
		
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CommonFunctions.swapScenes(MainCaixa.getStage(), DirectoryShortcuts.URL_SCENE_CAIXA_PAGINA_INICIAL, new PaginaInicialController());
			}
		});
	}
	
	private void update(String filter) {
		ArrayList<Produto> produtos = ProdutoDAO.getAll(filter);
		
		linearLayoutListaProdutos.getChildren().clear();
		listaProdutos.clear();
		for(Produto produto : produtos) {
			linearLayoutListaProdutos.getChildren().add(ElementProduto.create(produto));
		}
	}
	
	private void resetFields() {
		txtNome.setText("");
		txtPreco.setText("");
		choiceBoxTipo.getSelectionModel().selectFirst();
		txtDescricao.setText("");
		img.setImage(null);
		imgProduto = null;
	}
	
}


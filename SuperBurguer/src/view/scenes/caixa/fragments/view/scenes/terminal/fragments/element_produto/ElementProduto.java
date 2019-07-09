package view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_produto;

import java.io.IOException;

import database.models.Produto;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import view.scenes.caixa.cadastrar_produto.CadastrarProdutoController;
import view.util.DirectoryShortcuts;

public class ElementProduto {

	public static Pane create(Produto produto) {
		try {
			FXMLLoader loader = new FXMLLoader(DirectoryShortcuts.URL_ELEMENT_PRODUTO);
			
			ElementProdutoController controller = new ElementProdutoController(produto);
			
			CadastrarProdutoController.listaProdutos.put(produto, controller);
			
			loader.setController(controller);
			Pane pane = loader.load();
			return pane;
		} catch (IOException ex) {
			System.err.println("Não foi possível criar elemento de produto.");
			ex.printStackTrace();
			return null;
		}
	}
	
}

package view.scenes.terminal.fragments.element_menu_cardapio;

import java.io.IOException;

import database.models.Produto;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import view.util.DirectoryShortcuts;

public class ElementMenuCardapio {
	
	public static Pane create(VBox linearLayoutCarrinho, Produto produto) {
		try {
			FXMLLoader loader = new FXMLLoader(DirectoryShortcuts.URL_ELEMENT_MENU_CARDAPIO);
			
			ElementMenuCardapioController controller = new ElementMenuCardapioController(linearLayoutCarrinho, produto);
			loader.setController(controller);
			Pane pane = loader.load();
			return pane;
		} catch (IOException ex) {
			System.err.println("Não foi possível criar elemento do menu de cardápio.");
			ex.printStackTrace();
			return null;
		}
	}

}

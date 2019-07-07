package view.scenes.terminal.fragments.element_dialog_finalizar_pedido;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import view.scenes.terminal.fragments.element_menu_cardapio.ElementMenuCardapioController;
import view.util.DirectoryShortcuts;

public class ElementDialogFinalizarPedido {

	public static Pane create(VBox linearLayoutCarrinho) {
		try {
			FXMLLoader loader = new FXMLLoader(DirectoryShortcuts.URL_ELEMENT_DIALOG_FINALIZAR_PEDIDO);
			
//			ElementMenuCardapioController controller = new ElementMenuCardapioController(linearLayoutCarrinho);
//			loader.setController(controller);
			Pane pane = loader.load();
			return pane;
		} catch (IOException ex) {
			System.err.println("Não foi possível criar elemento do dialogo de finalizaçao do pedido.");
			ex.printStackTrace();
			return null;
		}
	}
	
}

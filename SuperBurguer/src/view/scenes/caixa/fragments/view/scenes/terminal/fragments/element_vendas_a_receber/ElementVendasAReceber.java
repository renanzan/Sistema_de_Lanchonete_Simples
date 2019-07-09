package view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_vendas_a_receber;

import java.io.IOException;

import database.models.Pedido;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import view.util.DirectoryShortcuts;

public class ElementVendasAReceber {

	public static Pane create(Pedido pedido) {
		try {
			FXMLLoader loader = new FXMLLoader(DirectoryShortcuts.URL_ELEMENT_VENDAS_A_RECEBER);
			
			ElementVendasAReceberController controller = new ElementVendasAReceberController(pedido);
			loader.setController(controller);
			Pane pane = loader.load();
			return pane;
		} catch (IOException ex) {
			System.err.println("Não foi possível criar elemento de venda a receber.");
			ex.printStackTrace();
			return null;
		}
	}
	
}

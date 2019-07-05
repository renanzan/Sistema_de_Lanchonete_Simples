package view.scenes.pagina_inicial;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class PaginaInicialController implements Initializable {

	@FXML
	private ImageView img_logo;
	
    @FXML
    private JFXButton btn_iniciar;
    
    public PaginaInicialController() {}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		img_logo.setPreserveRatio(true);
		
		btn_iniciar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("INICIAR!");
			}
		});
		
	}

}

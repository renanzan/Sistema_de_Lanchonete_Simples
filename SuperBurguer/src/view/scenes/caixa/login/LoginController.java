package view.scenes.caixa.login;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import database.dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MainCaixa;
import view.scenes.caixa.pagina_inicial.PaginaInicialController;
import view.util.CommonFunctions;
import view.util.DirectoryShortcuts;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField txt_login;

    @FXML
    private JFXPasswordField txt_senha;

    @FXML
    private JFXButton btn_conectar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_conectar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				connect();
			}
		});
	}
	
	private void connect() {
		MainCaixa.currentUser = UsuarioDAO.autenticar(txt_login.getText(), txt_senha.getText());
		
		if(MainCaixa.currentUser != null)
			CommonFunctions.swapScenes(MainCaixa.getStage(), DirectoryShortcuts.URL_SCENE_CAIXA_PAGINA_INICIAL, new PaginaInicialController());
		else
			JOptionPane.showMessageDialog(null, "Nome de usuário ou senha incorretos.");
	}

}

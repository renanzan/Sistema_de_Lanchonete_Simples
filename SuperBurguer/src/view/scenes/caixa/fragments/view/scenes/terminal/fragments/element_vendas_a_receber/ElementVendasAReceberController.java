package view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_vendas_a_receber;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import database.models.Pedido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ElementVendasAReceberController implements Initializable {
	
	private Pedido pedido;
	
	@FXML
    private Label txt_cod_pedido;

    @FXML
    private Label txt_data;

    @FXML
    private Label txt_hora;

    @FXML
    private Label txt_valor_reais;

    @FXML
    private Label txt_valor_centavos;

    @FXML
    private JFXButton btn_ok;
    
    public ElementVendasAReceberController(Pedido pedido) {
    	this.pedido = pedido;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txt_cod_pedido.setText(pedido.getNumPedido());
		
		txt_data.setText(String.format("%02d/%02d/%02d", pedido.getDataHora().getDayOfMonth(), pedido.getDataHora().getMonthValue(), pedido.getDataHora().getYear()));
		txt_hora.setText(String.format("%02d:%02d:%02d", pedido.getDataHora().getHour(), pedido.getDataHora().getMinute(), pedido.getDataHora().getSecond()));
		
		String valor[] = String.format("%.02f", pedido.getPreco()).split(",");
		txt_valor_reais.setText(valor[0]);
		txt_valor_centavos.setText(String.format("%02d", Integer.parseInt(valor[1])));
		
		btn_ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int dinheiro = Integer.parseInt(JOptionPane.showInputDialog("Dinheiro: "));
				
				if(dinheiro > 0)
					JOptionPane.showMessageDialog(null, "Devolver " + pedido.efetuarPagamento(dinheiro) + " de troco.");
			}
		});
	}

}

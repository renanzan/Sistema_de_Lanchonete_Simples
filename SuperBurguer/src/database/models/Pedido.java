package database.models;

import java.util.ArrayList;

public class Pedido {

	public enum Status {
		PAGO,
		PENDENTE
	}
	
	private String codCliente;
	private ArrayList<Produto> produtos;
	private Status status;
	
	public double getPreco() {
		double preco = 0;
		
		for(Produto produto : produtos)
			preco += produto.getPreco();
		
		return preco;
	}
	
	public double efetuarPagamento(double dinheiro) {
		double troco = getPreco() - dinheiro;
		
		if(troco > 0) {
			this.status = Status.PAGO;
			return troco;
		} else
			return -1;
	}
	
}

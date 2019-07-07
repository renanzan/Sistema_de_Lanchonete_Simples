package database.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import database.dao.ItensDoPedidoDAO;

public class Pedido {

	public enum Status {
		PAGO,
		PENDENTE
	}
	
	private int numPedido;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Status status;
	private LocalDateTime dataHora;
	
	public Pedido() {}
	
	public Pedido(int numPedido, Status status, Timestamp dataHora) {
		this.numPedido = numPedido;
		this.produtos = ItensDoPedidoDAO.getProdutos(numPedido);
		this.status = status;
		this.dataHora = dataHora.toLocalDateTime();
	}
	
	public static Status toStatus(String status) {
		return Status.valueOf(status.toUpperCase());
	}
	
	public int getNumPedido() {
		return numPedido;
	}

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
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
}

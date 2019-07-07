package database.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

import database.dao.ItensDoPedidoDAO;

public class Pedido {

	public enum Status {
		PAGO,
		PENDENTE
	}
	
	private String numPedido;
	private HashMap<Produto, Integer> produtos = new HashMap<>();
	private Status status;
	private LocalDateTime dataHora;
	
	public Pedido() {
		this.numPedido = UUID.randomUUID().toString();
	}
	
	public Pedido(String numPedido, Status status, Timestamp dataHora) {
		this.numPedido = numPedido;
		this.produtos = ItensDoPedidoDAO.getProdutos(numPedido);
		this.status = status;
		this.dataHora = dataHora.toLocalDateTime();
	}
	
	public static Status toStatus(String status) {
		return Status.valueOf(status.toUpperCase());
	}
	
	public String getNumPedido() {
		return numPedido;
	}

	public double getPreco() {
		double preco = 0;
		
		for(Produto produto : produtos.keySet())
			preco += (produtos.get(produto) * produto.getPreco());
		
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
	
	public HashMap<Produto, Integer> getProdutos() {
		return produtos;
	}
	
}

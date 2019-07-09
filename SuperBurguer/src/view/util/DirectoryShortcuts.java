package view.util;

import java.net.URL;

import view.scenes.caixa.cadastrar_produto.CadastrarProdutoController;
import view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_produto.ElementProdutoController;
import view.scenes.caixa.fragments.view.scenes.terminal.fragments.element_vendas_a_receber.ElementVendasAReceberController;
import view.scenes.caixa.login.LoginController;
import view.scenes.caixa.pagina_inicial.PaginaInicialController;
import view.scenes.terminal.fragments.element_dialog_finalizar_pedido.ElementDialogFinalizarPedidoController;
import view.scenes.terminal.fragments.element_menu_cardapio.ElementMenuCardapioController;
import view.scenes.terminal.fragments.element_menu_carrinho.ElementMenuCarrinhoController;

public class DirectoryShortcuts {

	/** TERMINAL **/
	
		/** FRAGMENTS **/
		public static final URL URL_ELEMENT_DIALOG_FINALIZAR_PEDIDO = ElementDialogFinalizarPedidoController.class.getResource("\\FXML_Element_Dialog_Finalizar_Pedido.fxml");
		public static final URL URL_ELEMENT_MENU_CARDAPIO = ElementMenuCardapioController.class.getResource("\\FXML_Element_Menu_Cardapio.fxml");
		public static final URL URL_ELEMENT_MENU_CARRINHO = ElementMenuCarrinhoController.class.getResource("\\FXML_Element_Menu_Carrinho.fxml");
	
	/** ********** **/
	
	
	
	/** CAIXA **/
		
		/** SCENES **/
		public static final URL URL_SCENE_CAIXA_LOGIN = LoginController.class.getResource("\\FXML_Login.fxml");
		public static final URL URL_SCENE_CAIXA_PAGINA_INICIAL = PaginaInicialController.class.getResource("\\FXML_Pagina_Inicial.fxml");
		public static final URL URL_SCENE_CADASTRAR_PRODUTO = CadastrarProdutoController.class.getResource("\\FXML_Cadastrar_Produto.fxml");
		
		/** FRAGMENTS **/
		public static final URL URL_ELEMENT_VENDAS_A_RECEBER = ElementVendasAReceberController.class.getResource("\\FXML_Element_Vendas_A_Receber.fxml");
		public static final URL URL_ELEMENT_PRODUTO = ElementProdutoController.class.getResource("\\FXML_Element_Produto.fxml");
		
	/** ********** **/
}

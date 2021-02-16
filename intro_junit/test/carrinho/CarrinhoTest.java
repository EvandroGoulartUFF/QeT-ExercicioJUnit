package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;



@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto produto1, produto2;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		produto1 = new Produto("Introdução ao Teste de Software", 100.00);
	    produto2 = new Produto("Introdução à Engenharia de Software", 80.00);
	}

	@DisplayName("Testa se produto foi adicionado ao carrinho")
	@Test
	public void testProdutoAdicionadoCarrinho() {
		carrinho.addItem(produto1);
		Assertions.assertTrue(carrinho.getItems().contains(produto1));
	}
	
	@DisplayName("Testa se produto foi removido do carrinho")
	@Test
	public void testProdutoRemovidoCarrinho() throws ProdutoNaoEncontradoException {
		carrinho.addItem(produto1);
		carrinho.removeItem(produto1);
		Assertions.assertFalse(carrinho.getItems().contains(produto1));
	}
	
	@DisplayName("Testa a Exception ao tentar remover um produto não encontrado no carrinho")
	@Test
	public void testRemoverProdutoException() {
		Assertions.assertThrows(ProdutoNaoEncontradoException.class, 
				() -> carrinho.removeItem(produto1));
	}
	
	@DisplayName("Testa a quantidade de produtos no carrinho")
	@Test
	public void testQtdProdutosCarrinho() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		Assertions.assertEquals(2, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa o valor total do carrinho")
	@Test
	public void testValorTotalCarrinho() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		Assertions.assertEquals(180, carrinho.getValorTotal());	
	}
	
	@DisplayName("Testa se carrinho foi esvaziado")
	@Test
	public void testCarrinhoVazio() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		carrinho.esvazia();
		Assertions.assertTrue(carrinho.getItems().isEmpty());
	}
	
}

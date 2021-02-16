package carrinho;

import java.util.ArrayList;
import java.util.Iterator;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class Carrinho {
	
	private ArrayList items;
	
	public Carrinho() {
		setItems(new ArrayList());
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		
		for (Iterator i = getItems().iterator(); i.hasNext();) {
			Produto item = (Produto) i.next();
			valorTotal += item.getPreco();
		}
	
		return valorTotal;
	}
	
	public void addItem(Produto item) {
		getItems().add(item);
	}
	
	public void removeItem(Produto item) throws ProdutoNaoEncontradoException {
		if (!getItems().remove(item)) {
			throw new ProdutoNaoEncontradoException();
		}
	}
	
	public int getQtdeItems() {
		return getItems().size();
	}
	
	public void esvazia() {
		getItems().clear();
	}

	public ArrayList getItems() {
		return items;
	}

	public void setItems(ArrayList items) {
		this.items = items;
	}
	

}

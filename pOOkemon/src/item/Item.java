package item;

public class Item {
	private String nome;
	private int cura;
	
	public Item(String nomeItem, int curaItem){
		nome = nomeItem;
		cura = curaItem;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getCura(){
		return cura;
	}
}

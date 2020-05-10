import java.io.Serializable;
import java.util.LinkedList;

public class Pilha implements Serializable {

	private static final long serialVersionUID = 1L;
	// Cria��o de uma linkedList de caracteres
	LinkedList<Caracter> caracteres = new LinkedList<Caracter>();

	// Pega o �ltimo elemento da pilha, mas s� para checar (olhar)
	// n�o remove o elemento
	public char peek() {
		return caracteres.getLast().getConteudo();// Pegando conte�do do pr�ximo caractere
	}

	// Adiciona elemento da pilha do tipo char
	public void push(char c) {
		Caracter car = new Caracter();// Novo caracter
		car.setConteudo(c);// Passando o conte�do do caracter
		caracteres.push(car);// Inserindo elemento na pilha de caracteres
	}

	// M�todo para empilhar caracter c
	public void empilha(Caracter c) {
		caracteres.push(c);// Inserindo c na pilha
	}

	// Desempilhar caracter da pilha
	public Caracter desempilha() {
		// Tratando da pilha vazia
		if (eVazia()) {
			System.out.println("Pilha est� vazia.");
			return null;
		} else {
			// caracterRemovido recebe a refer�ncia do caractere removido da pilha
			Caracter caracterRemovido = this.caracteres.pop();
			return caracterRemovido;// Retorna caractere removido
		}
	}

	// Remove elemento da pilha
	public char pop() {
		// Testando se pilha est� vazia
		if (eVazia()) {
			System.out.println("Pilha est� vazia.");
			return ' ';
		} else {
			// caracterRemovido recebe a refer�ncia do caractere removido da pilha
			Caracter caracterRemovido = this.caracteres.pop();
			return caracterRemovido.getConteudo();// Obtendo conte�do removido
		}
	}

	// Verifica se a pilha � vazia
	public boolean eVazia() {
		return caracteres.isEmpty();
	}
}
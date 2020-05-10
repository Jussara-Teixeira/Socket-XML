import java.io.Serializable;

public class Caracter implements Serializable{

	private static final long serialVersionUID = 1L;
	//Definindo conte�do do tipo char
	char conteudo;
    //M�todo para pegar o conte�do de char
	public char getConteudo() {
		return conteudo;//Retornando o conte�do
	}
	//M�todo que recebe como argumento conte�do
	public void setConteudo(char conteudo) {
		this.conteudo = conteudo;
	}
	//M�todo para tratar string
	public String toString() {
		//Retornando conte�do da string
		return String.valueOf(conteudo);
	}
}

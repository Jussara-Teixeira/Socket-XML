import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.thoughtworks.xstream.XStream;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;
		BufferedReader socketEntrada;
		Socket connectionSocket;

		try {
			welcomeSocket = new ServerSocket(9090);

			System.out.println("Servidor no ar");
			while (true) {

				connectionSocket = welcomeSocket.accept();
				System.out.println("Nova conexao");

				// Interpretando dados do servidor
				socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				String xmlRecebido = socketEntrada.readLine();

				// DESEREALIZA
				XStream xstream = new XStream();// Criando
				Pilha pilha = (Pilha) xstream.fromXML(xmlRecebido, Pilha.class);

				// Recebendo expressão

				String resultadoDaExpressao = " ";
				float resultadoDaExpressa = PosFix.calculateExpression(pilha);
				System.out.println(resultadoDaExpressa);

				// Enviando dados para o servidor
				socketOutput = new DataOutputStream(connectionSocket.getOutputStream());
				socketOutput.writeBytes(resultadoDaExpressao + '\n');
				socketOutput.flush();
				socketOutput.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacoes {
	private List<Conta> contas = new ArrayList<>();
	private Scanner s;

	public Operacoes(Scanner s) {
		this.s = s;
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void sacar() {
		System.out.println("Saque\n");

		Conta conta = buscarPorNumero(lerCampo("Numero da conta: "));
		if (conta == null) {
			System.out.println("Conta nao encontrada!");
			return;
		}
		System.out.println(conta);

		double valor;
		try {
			valor = Double.parseDouble(lerCampo("Valor do saque: ").replace(",", "."));
		} catch (NumberFormatException e) {
			System.out.println("Valor invalido!");
			return;
		}

		try {
			conta.sacar(valor);
			System.out.println("Saque realizado com sucesso!");
			System.out.println(conta);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public Conta buscarPorNumero(String numero) {
		for (Conta conta : contas) {
			if (String.valueOf(conta.getNumero()).equals(numero)) {
				return conta;
			}
		}
		return null;
	}

	private String lerCampo(String rotulo) {
		System.out.println(rotulo);
		return s.nextLine().trim();
	}
}
